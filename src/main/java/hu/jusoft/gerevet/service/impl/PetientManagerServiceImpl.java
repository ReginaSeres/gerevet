package hu.jusoft.gerevet.service.impl;

import hu.jusoft.gerevet.domain.model.Patient;
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
    private ListingPatientService listingPatientService;

    @Override
    public Patient getActualPatientFromId(String id) {
        List<Patient> listOfPatient = listingPatientService.getListOfPatient();
        Patient resultPatient = new Patient();

        for (int i = 0; i < listOfPatient.size(); i++) {
            if (id.equals(listOfPatient.get(i).getId())) {
                resultPatient = listOfPatient.get(i);
                break;
            }
        }

        return resultPatient;
    }
}
