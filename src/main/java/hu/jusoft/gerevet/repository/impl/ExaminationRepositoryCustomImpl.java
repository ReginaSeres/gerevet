package hu.jusoft.gerevet.repository.impl;

import com.mongodb.gridfs.GridFSFile;
import hu.jusoft.gerevet.repository.ExaminationRepositoryCustom;
import hu.jusoft.gerevet.repository.model.ExaminationFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Repository;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by Regina Seres on 1/3/2016.
 */
@Repository
public class ExaminationRepositoryCustomImpl implements ExaminationRepositoryCustom {

    @Autowired
    private GridFsOperations gridOperations;

    @Override
    public String addImageToExamination(String examinationId, ExaminationFile examinationFile) {
        InputStream inputStream = new ByteArrayInputStream(examinationFile.getFile());
        GridFSFile gridFSFile = gridOperations.store(inputStream, examinationFile.getName(), examinationFile.getContentType());

        return gridFSFile.getId().toString();
    }
}
