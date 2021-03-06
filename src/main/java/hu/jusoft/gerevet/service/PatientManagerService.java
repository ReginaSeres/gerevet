package hu.jusoft.gerevet.service;

import hu.jusoft.gerevet.repository.model.Patient;
import hu.jusoft.gerevet.view.model.PatientPageModel;

import java.util.List;

/**
 * Created by Regina Seres on 12/10/2015.
 */
public interface PatientManagerService {

    Patient findTheOnlyPatientById (String id);

    Patient save(Patient patient);

    List<Patient> findAllPatient();
}
