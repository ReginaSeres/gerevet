package hu.jusoft.gerevet.repository;

import hu.jusoft.gerevet.repository.model.ExaminationFile;

/**
 * Created by Regina Seres on 1/3/2016.
 */
public interface ExaminationRepositoryCustom {

    String addImageToExamination(String examinationId, ExaminationFile picture);

}
