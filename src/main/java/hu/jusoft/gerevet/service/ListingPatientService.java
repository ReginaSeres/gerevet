package hu.jusoft.gerevet.service;

import hu.jusoft.gerevet.view.model.PatientPageModel;

import java.util.List;

/**
 * Created by Regina Seres on 12/10/2015.
 */
public interface ListingPatientService {

    List<PatientPageModel> getListOfPatient();

}
