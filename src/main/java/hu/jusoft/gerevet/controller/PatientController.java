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

    @RequestMapping("/patient/{id}")
    public ModelAndView patient(@PathVariable("id") String id) {
        Patient patient = patientManagerService.findOne(id);

        ModelAndView mav = new ModelAndView("patient");
        mav.addAllObjects(patientModelBuilder.buildPatientModelMap(patient));

        return mav;
    }

    @RequestMapping("/addPatient")
    public ModelAndView addPatient() {
        ModelAndView mav = new ModelAndView("addPatient");

        return mav;
    }

    @RequestMapping(value = "/savePatient", method = RequestMethod.POST)
    public void savePatient(
            @ModelAttribute("patientPageModel") PatientPageModel patientPageModel, HttpServletResponse response) throws IOException {
        String id = patientManagerService.save(patientBuilder.buildFromPageModel(patientPageModel));
        response.sendRedirect("/patient/" + id);
    }

    @ResponseBody
    @RequestMapping(value = {"/updatePatient"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public PatientPageModel updatePatient(@RequestBody PatientPageModel patient) {
        return patient;
    }
}
