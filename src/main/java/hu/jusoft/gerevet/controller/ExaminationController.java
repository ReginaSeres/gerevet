package hu.jusoft.gerevet.controller;

import hu.jusoft.gerevet.repository.model.*;
import hu.jusoft.gerevet.service.ExaminationManagerService;
import hu.jusoft.gerevet.service.PatientManagerService;
import hu.jusoft.gerevet.validator.NewExaminationPageModelValidator;
import hu.jusoft.gerevet.view.model.NewExaminationPageModel;
import hu.jusoft.gerevet.view.modelbuilder.ExaminationModelBuilder;
import hu.jusoft.gerevet.view.modelbuilder.PatientModelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

import static hu.jusoft.gerevet.controller.ControllerConstants.*;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Controller
public class ExaminationController {

    @Autowired
    private MessageSource msg;

    @Autowired
    private ExaminationModelBuilder examinationModelBuilder;

    @Autowired
    private ExaminationManagerService examinationManagerService;

    @Autowired
    private PatientManagerService patientManagerService;

    @Autowired
    private PatientModelBuilder patientModelBuilder;

    @Autowired
    private NewExaminationPageModelValidator examinationValidator;

    @InitBinder(EXAMINATION_PAGE_MODEL_NAME)
    public void initEUSearchBinder(WebDataBinder binder) {
        binder.addValidators(examinationValidator);
    }

    @RequestMapping(value = EXAMINATION_PARAMETERIZED_URL)
    public ModelAndView examination(@PathVariable(EXAMINATION_INDEX_VARIABLE) String id) {
        Examination examination = examinationManagerService.findExaminationByExaminationId(id);

        ModelAndView mav = new ModelAndView(EXAMINATION);
        mav.addAllObjects(examinationModelBuilder.buildExaminationMap(examination));

        return mav;
    }

    @RequestMapping(value = ADD_EXAMINATION_URL)
    public ModelAndView addExamination() {
        List<Patient> listOfPatients = patientManagerService.findAllPatient();

        if (listOfPatients.size() == 0) {
            return new ModelAndView("redirect:" + ADD_PATIENT_URL + "?patientListIsEmpty=true");
        }

        ModelAndView mav = new ModelAndView(ADD_EXAMINATION);
        mav.addAllObjects(patientModelBuilder.buildPatientModelMap(listOfPatients));

        return mav;
    }

    @ResponseBody
    @RequestMapping(value = ADD_EXAMINATION_URL, method = RequestMethod.POST)
    public ModelAndView saveExamination(@Valid @ModelAttribute(EXAMINATION_PAGE_MODEL_NAME) NewExaminationPageModel examinationPageModel,
                                        BindingResult bindingResult, Locale locale) throws IOException {
        List<Patient> listOfPatients = patientManagerService.findAllPatient();
        if (listOfPatients.size() == 0) {
            return new ModelAndView("redirect:" + ADD_PATIENT_URL + "?patientListIsEmpty=true");
        }

        if (bindingResult.hasErrors()) {
            List<String> errorList = new ArrayList<>();
            for (ObjectError oe : bindingResult.getGlobalErrors()) {
                errorList.add(msg.getMessage(oe.getDefaultMessage(), null, locale));
            }
            Map<String, Object> model = new HashMap<>();
            model.put("errorList", errorList);

            ModelAndView mav = new ModelAndView(ADD_EXAMINATION);
            mav.addAllObjects(model);
            mav.addAllObjects(patientModelBuilder.buildPatientModelMap(listOfPatients));

            return mav;
        }

        Examination examination = examinationModelBuilder.buildExaminationMap(examinationPageModel);

        examinationManagerService.save(examination);

        saveFilesToExamination(examination, examinationPageModel.getDocumentsFiles(), false);

        saveFilesToExamination(examination, examinationPageModel.getPicturesFiles(), true);

        return new ModelAndView("redirect:" + EXAMINATION_URL + "/" + examination.getId());
    }

    private void saveFilesToExamination(Examination examination, List<MultipartFile> documentsFiles, boolean isPicture) {
        for (MultipartFile file : documentsFiles) {
            saveFile(examination, file, isPicture);
        }
    }

    private void saveFile(Examination examination, MultipartFile file, boolean isPicture) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                ExaminationFile examinationFile = new ExaminationFile(file.getOriginalFilename(), file.getContentType(), bytes);

                examinationManagerService.addImageToExamination(examination, examinationFile, isPicture);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
        }
    }
}
