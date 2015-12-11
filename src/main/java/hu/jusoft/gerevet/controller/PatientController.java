package hu.jusoft.gerevet.controller;

import hu.jusoft.gerevet.modelbuilder.PatientModelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/editPatient/{id}")
    public String editPatient(@PathVariable("id") String id, Model model) {
        return patientModelBuilder.buildEditPatientModelMap(id, model);
    }

    @RequestMapping("/updatePatient/{id}")
    public String updatePatient(@PathVariable("id") String id, Model model) {
        return "editPatient";
    }
}
