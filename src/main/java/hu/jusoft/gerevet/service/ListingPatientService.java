package hu.jusoft.gerevet.service;

import hu.jusoft.gerevet.domain.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Regina Seres on 12/10/2015.
 */
public interface ListingPatientService {

    public List<Patient> getTenPatientFromActualPage(int actPage);

    public int getPagesCount();

    public List<Patient> getListOfPatientFromQuery(String query);

    public List<Patient> getListOfPatient();
}
