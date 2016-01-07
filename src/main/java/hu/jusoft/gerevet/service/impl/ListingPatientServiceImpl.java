package hu.jusoft.gerevet.service.impl;

import hu.jusoft.gerevet.view.model.PatientPageModel;
import hu.jusoft.gerevet.service.ListingPatientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Regina Seres on 12/10/2015.
 */
@Service
public class ListingPatientServiceImpl implements ListingPatientService {
    private List<PatientPageModel> listOfPatient = new ArrayList<>();

    @Override
    public List<PatientPageModel> getListOfPatient() {
        return new ArrayList<>(listOfPatient);
    }
}
