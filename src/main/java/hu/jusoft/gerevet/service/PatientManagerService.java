package hu.jusoft.gerevet.service;

import hu.jusoft.gerevet.domain.model.Patient;

/**
 * Created by Regina Seres on 12/10/2015.
 */
public interface PatientManagerService {

    public Patient getActualPatientFromId(String id);
}
