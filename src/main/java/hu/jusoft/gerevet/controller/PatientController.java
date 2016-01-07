package hu.jusoft.gerevet.controller;

import hu.jusoft.gerevet.repository.model.Patient;
import hu.jusoft.gerevet.service.PatientManagerService;
import hu.jusoft.gerevet.service.builder.PatientBuilder;
import hu.jusoft.gerevet.view.model.PatientPageModel;
import hu.jusoft.gerevet.view.modelbuilder.PatientModelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static hu.jusoft.gerevet.controller.ControllerConstants.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Regina Seres on 12/10/2015.
 */
@Controller
public class PatientController {

    @Autowired
    private PatientManagerService patientManagerService;

    @Autowired
    private PatientBuilder patientBuilder;

    @Autowired
    private PatientModelBuilder patientModelBuilder;

    @RequestMapping(value = PATIENT_PARAMETRIZED_URL)
    public ModelAndView patient(@PathVariable(PATIENT_INDEX_VARIABLE) String id) {
        Patient patient = patientManagerService.findTheOnlyPatientById(id);

        ModelAndView mav = new ModelAndView(PATIENT);
        mav.addAllObjects(patientModelBuilder.buildPatientModelMap(patient));

        return mav;
    }

    @RequestMapping(value = ADD_PATIENT_URL)
    public ModelAndView addPatient() {
        ModelAndView mav = new ModelAndView(ADD_PATIENT);

        return mav;
    }

    @RequestMapping(value = SAVE_PATIENT_URL, method = RequestMethod.POST)
    public void savePatient(
            @ModelAttribute(PATIENT_PAGE_MODEL) PatientPageModel patientPageModel, HttpServletResponse response) throws IOException {
        String id = patientManagerService.save(patientBuilder.buildFromPageModel(patientPageModel));
        response.sendRedirect(PATIENT_URL + "/" + id);
    }

    @ResponseBody
    @RequestMapping(value = UPDATE_PATIENT_URL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public PatientPageModel updatePatient(@RequestBody PatientPageModel patient) {
        return patient;
    }

    @ResponseBody
    @RequestMapping(value = PATIENT_PARAMETERIZED_URL)
    public Patient saveExamination(@ModelAttribute(PATIENTID_INDEX_VARIABLE) String patientId) throws IOException {
        Patient patient = patientManagerService.findTheOnlyPatientById(patientId);

        return patient;
    }
}
