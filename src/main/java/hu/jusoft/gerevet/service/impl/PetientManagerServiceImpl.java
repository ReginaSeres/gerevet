package hu.jusoft.gerevet.service.impl;

import hu.jusoft.gerevet.repository.model.Patient;
import hu.jusoft.gerevet.view.model.PatientPageModel;
import hu.jusoft.gerevet.repository.PatientRepository;
import hu.jusoft.gerevet.service.ListingPatientService;
import hu.jusoft.gerevet.service.PatientManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Regina Seres on 12/10/2015.
 */
@Service
public class PetientManagerServiceImpl implements PatientManagerService {

    @Autowired
    private ListingPatientService listingPatientService;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PatientPageModel getActualPatientFromId(String id) {
        List<PatientPageModel> listOfPatient = listingPatientService.getListOfPatient();
        PatientPageModel resultPatient = new PatientPageModel();

        for (int i = 0; i < listOfPatient.size(); i++) {
            if (id.equals(listOfPatient.get(i).getId())) {
                resultPatient = listOfPatient.get(i);
                break;
            }
        }

        return resultPatient;
    }

    @Override
    public Patient findTheOnlyPatientById (String id) {
        return patientRepository.findOne(id);
    }

    @Override
    public String save(Patient patient) {
        patientRepository.save(patient);
        return patient.getId();
    }

    @Override
    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }
}