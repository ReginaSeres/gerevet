package hu.jusoft.gerevet.view.modelbuilder;

import hu.jusoft.gerevet.repository.model.Patient;
import hu.jusoft.gerevet.view.model.ExaminationPageModel;
import hu.jusoft.gerevet.view.model.PatientPageModel;
import org.springframework.stereotype.Component;

import static hu.jusoft.gerevet.controller.ControllerConstants.*;

import java.util.*;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Component
public class PatientModelBuilder {

    public Map<String,Object> buildPatientModelMap(Patient patient) {
        PatientPageModel patientPageModel = build(patient);

        Map<String, Object> model = new HashMap<>();
        model.put("patient", patientPageModel);
        model.put("examinations", new ArrayList<ExaminationPageModel>());
        model.put(EDIT_JS, EDIT_JS);

        return model;
    }

    public PatientPageModel build(Patient patient) {
        return new PatientPageModel(patient.getId(), patient.getName(), patient.getAddress(), patient.getCity(), patient.getPhoneNumber(), patient.getEmailAddress());
    }

    public Map<String, Object> buildPatientModelMap(List<Patient> listOfPatients) {
        List<PatientPageModel> listOfPatientsPageModel = new ArrayList<>();
        for (Patient patient : listOfPatients) {
            listOfPatientsPageModel.add(build(patient));
        }

        List<String> invoiceGroups = new ArrayList<>();
        invoiceGroups.add("Egyes");
        invoiceGroups.add("Kettes");
        invoiceGroups.add("Harmas");
        invoiceGroups.add("Negyes");

        Map<String, Object> model = new HashMap<>();
        model.put("patients", listOfPatientsPageModel);
        model.put("invoiceGroups", invoiceGroups);

        return model;
    }
}
