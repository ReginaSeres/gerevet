package hu.jusoft.gerevet.service;

import hu.jusoft.gerevet.repository.model.Examination;
import hu.jusoft.gerevet.view.model.ExaminationPageModel;

/**
 * Created by Regina Seres on 12/11/2015.
 */
public interface ExaminationManagerService {
    ExaminationPageModel getActualExaminationFromId(String examinationId);

    Examination findOne(String id);
}
