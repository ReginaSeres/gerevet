package hu.jusoft.gerevet.controller;

import hu.jusoft.gerevet.domain.model.Patient;
import hu.jusoft.gerevet.service.PatientManagerService;
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
    private PatientManagerService patientManagerService;

    @RequestMapping("/patient/{id}")
    public String patient(@PathVariable("id") String id, Model model) {
        Patient actualPatient = patientManagerService.getActualPatientFromId(id);

        System.out.println(actualPatient.getName());

        model.addAttribute("patient", actualPatient);

        return "patient";
    }
}
