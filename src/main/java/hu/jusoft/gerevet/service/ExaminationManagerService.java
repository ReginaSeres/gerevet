package hu.jusoft.gerevet.service;

import hu.jusoft.gerevet.domain.model.Examination;

/**
 * Created by Regina Seres on 12/11/2015.
 */
public interface ExaminationManagerService {
    Examination getActualExaminationFromId(String examinationId);
}
