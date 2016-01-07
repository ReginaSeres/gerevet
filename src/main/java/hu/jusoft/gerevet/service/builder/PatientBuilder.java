package hu.jusoft.gerevet.service.builder;

import hu.jusoft.gerevet.repository.model.Patient;
import hu.jusoft.gerevet.view.model.PatientPageModel;
import org.springframework.stereotype.Component;

/**
 * Created by Regina Seres on 12/17/2015.
 */
@Component
public class PatientBuilder {

    public Patient buildFromPageModel(PatientPageModel patientPageModel) {
        return new Patient(patientPageModel.getName(),
                patientPageModel.getCity(),
                patientPageModel.getAddress(),
                patientPageModel.getPhoneNumber(),
                patientPageModel.getEmailAddress());
    }
}
