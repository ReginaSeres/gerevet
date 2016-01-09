package hu.jusoft.gerevet.controller;

import hu.jusoft.gerevet.repository.model.Patient;
import hu.jusoft.gerevet.service.PatientManagerService;
import hu.jusoft.gerevet.service.builder.PatientBuilder;
import hu.jusoft.gerevet.validator.PatientPageModelValidator;
import hu.jusoft.gerevet.view.model.PatientPageModel;
import hu.jusoft.gerevet.view.modelbuilder.PatientModelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static hu.jusoft.gerevet.controller.ControllerConstants.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

/**
 * Created by Regina Seres on 12/10/2015.
 */
@Controller
public class PatientController {

    @Autowired
    private MessageSource msg;

    @Autowired
    private PatientManagerService patientManagerService;

    @Autowired
    private PatientBuilder patientBuilder;

    @Autowired
    private PatientModelBuilder patientModelBuilder;

    @Autowired
    private PatientPageModelValidator patientPageModelValidator;

    @InitBinder(PATIENT_PAGE_MODEL)
    public void initEUSearchBinder(WebDataBinder binder) {
        binder.addValidators(patientPageModelValidator);
    }

    @RequestMapping(value = PATIENT_PARAMETRIZED_URL)
    public ModelAndView patient(@PathVariable(PATIENT_INDEX_VARIABLE) String id) {
        Patient patient = patientManagerService.findTheOnlyPatientById(id);

        ModelAndView mav = new ModelAndView(PATIENT);
        mav.addAllObjects(patientModelBuilder.buildPatientModelMap(patient));

        return mav;
    }

    @RequestMapping(value = ADD_PATIENT_URL)
    public ModelAndView addPatient(@RequestParam(value = "patientListIsEmpty", required = false, defaultValue = "false") boolean patientListIsEmpty,
                                   Locale locale) {
        ModelAndView mav = new ModelAndView(ADD_PATIENT);

        if (patientListIsEmpty) {
            List<String> errorList = new ArrayList<>();
            errorList.add(msg.getMessage("patient.add.patient_list_is_empty", null, locale));

            Map<String, Object> model = new HashMap<>();
            model.put("errorList", errorList);

            mav.addAllObjects(model);
        }

        return mav;
    }

    @RequestMapping(value = ADD_PATIENT_URL, method = RequestMethod.POST)
    public ModelAndView savePatient(@Valid @ModelAttribute(PATIENT_PAGE_MODEL) PatientPageModel patientPageModel, BindingResult bindingResult, Locale locale) throws IOException {
        if (bindingResult.hasErrors()) {
            List<String> errorList = new ArrayList<>();
            for (ObjectError oe : bindingResult.getGlobalErrors()) {
                errorList.add(msg.getMessage(oe.getDefaultMessage(), null, locale));
            }
            Map<String, Object> model = new HashMap<>();
            model.put("errorList", errorList);

            ModelAndView mav = new ModelAndView(ADD_PATIENT);
            mav.addAllObjects(model);

            return mav;
        }
        String id = patientManagerService.save(patientBuilder.buildFromPageModel(patientPageModel)).getId();

        return new ModelAndView("redirect:" + PATIENT_URL + "/" + id);
    }

    @ResponseBody
    @RequestMapping(value = UPDATE_PATIENT_URL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public PatientPageModel updatePatient(@RequestBody PatientPageModel patientPageModel) {

        Patient patient = patientBuilder.buildFromPageModel(patientPageModel);

        patientManagerService.save(patient);

        return patientPageModel;
    }

    @ResponseBody
    @RequestMapping(value = PATIENT_PARAMETERIZED_URL)
    public Patient saveExamination(@ModelAttribute(PATIENTID_INDEX_VARIABLE) String patientId) throws IOException {
        Patient patient = patientManagerService.findTheOnlyPatientById(patientId);

        return patient;
    }
}
