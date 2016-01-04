package hu.jusoft.gerevet.repository.impl;

import com.mongodb.gridfs.GridFSFile;
import hu.jusoft.gerevet.repository.ExaminationRepository;
import hu.jusoft.gerevet.repository.ExaminationRepositoryCustom;
import hu.jusoft.gerevet.repository.model.Examination;
import hu.jusoft.gerevet.repository.model.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Repository;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Regina Seres on 1/3/2016.
 */
@Repository
public class ExaminationRepositoryCustomImpl implements ExaminationRepositoryCustom {

    @Autowired
    private ExaminationRepository examinationRepository;

    @Autowired
    private GridFsOperations gridOperations;

    @Override
    public String addImageToExamination(String examinationId, Picture picture) {
        examinationId = "566f091306583586f8ed32c7";

   /*     InputStream inputStream = new ByteArrayInputStream(picture.getPicture());
        GridFSFile gridFSFile = gridOperations.store(inputStream, picture.getName(), picture.getContentType());
        return gridFSFile.getId().toString();*/
        return null;
    }
}
