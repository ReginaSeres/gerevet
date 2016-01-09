package hu.jusoft.gerevet.service.impl;

import hu.jusoft.gerevet.repository.model.Patient;
import hu.jusoft.gerevet.view.model.PatientPageModel;
import hu.jusoft.gerevet.repository.PatientRepository;
import hu.jusoft.gerevet.service.ListingPatientService;
import hu.jusoft.gerevet.service.PatientManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Regina Seres on 12/10/2015.
 */
@Service
public class PetientManagerServiceImpl implements PatientManagerService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient findTheOnlyPatientById (String id) {
        return patientRepository.findOne(id);
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }
}