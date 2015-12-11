package hu.jusoft.gerevet.service;

import hu.jusoft.gerevet.domain.model.Examination;

import java.util.List;

/**
 * Created by Regina Seres on 12/11/2015.
 */
public interface ListingExaminationService {
    List<Examination> getTenExaminationFromActualPage(int actPage);

    int getPagesCount();

    List<Examination> getListOfExaminations();

    List<Examination> getListOfExaminationsForActualPatientId(String actualPatientId);
}
