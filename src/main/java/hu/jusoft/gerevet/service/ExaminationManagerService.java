package hu.jusoft.gerevet.service;

import com.mongodb.gridfs.GridFSDBFile;
import hu.jusoft.gerevet.repository.model.Examination;
import hu.jusoft.gerevet.repository.model.Picture;
import hu.jusoft.gerevet.view.model.ExaminationPageModel;

/**
 * Created by Regina Seres on 12/11/2015.
 */
public interface ExaminationManagerService {
    ExaminationPageModel getActualExaminationFromId(String examinationId);

    Examination findExaminationByExaminationId(String id);

    void addImageToExamination(String examinationId, Picture picture);

    GridFSDBFile findImageById(String id);
}
