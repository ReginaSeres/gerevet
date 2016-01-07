package hu.jusoft.gerevet.controller;

import hu.jusoft.gerevet.repository.model.*;
import hu.jusoft.gerevet.service.ExaminationManagerService;
import hu.jusoft.gerevet.service.PatientManagerService;
import hu.jusoft.gerevet.view.model.NewExaminationPageModel;
import hu.jusoft.gerevet.view.modelbuilder.ExaminationModelBuilder;
import hu.jusoft.gerevet.view.modelbuilder.PatientModelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static hu.jusoft.gerevet.controller.ControllerConstants.*;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Controller
public class ExaminationController {

    @Autowired
    private ExaminationModelBuilder examinationModelBuilder;

    @Autowired
    private ExaminationManagerService examinationManagerService;

    @Autowired
    private PatientManagerService patientManagerService;

    @Autowired
    private PatientModelBuilder patientModelBuilder;

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

        ModelAndView mav = new ModelAndView(ADD_EXAMINATION);
        mav.addAllObjects(patientModelBuilder.buildPatientModelMap(listOfPatients));

        return mav;
    }

    @ResponseBody
    @RequestMapping(value = SAVE_EXAMINATION_URL, method = RequestMethod.POST)
    public String saveExamination(@ModelAttribute(EXAMINATION_PAGE_MODEL_NAME) NewExaminationPageModel examinationPageModel, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Examination examination = examinationModelBuilder.buildExaminationMap(examinationPageModel);

        examinationManagerService.save(examination);

        saveFilesToExamination(examination, examinationPageModel.getDocumentsFiles(), false);

        saveFilesToExamination(examination, examinationPageModel.getPicturesFiles(), true);

        return EXAMINATION_URL + "/" + examination.getId();
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
