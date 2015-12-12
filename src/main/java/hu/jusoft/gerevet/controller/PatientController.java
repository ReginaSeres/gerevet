package hu.jusoft.gerevet.controller;

import hu.jusoft.gerevet.domain.model.Patient;
import hu.jusoft.gerevet.modelbuilder.PatientModelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Regina Seres on 12/10/2015.
 */
@Controller
public class PatientController {

    @Autowired
    private PatientModelBuilder patientModelBuilder;

    @RequestMapping("/patient/{id}")
    public String patient(@PathVariable("id") String id, Model model) {
        return patientModelBuilder.buildPatientModelMap(id, model);
    }

    @ResponseBody
    @RequestMapping(value = {"/updatePatient"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient updatePatient(@RequestBody Patient patient) {
        System.out.println(patient.getName());
        return patient;
    }
}
