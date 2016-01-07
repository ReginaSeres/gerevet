package hu.jusoft.gerevet.service.impl;

import com.mongodb.gridfs.GridFSDBFile;
import hu.jusoft.gerevet.repository.ExaminationRepositoryCustom;
import hu.jusoft.gerevet.repository.model.Examination;
import hu.jusoft.gerevet.repository.model.ExaminationFile;
import hu.jusoft.gerevet.repository.model.FileData;
import hu.jusoft.gerevet.view.model.ExaminationPageModel;
import hu.jusoft.gerevet.repository.ExaminationRepository;
import hu.jusoft.gerevet.service.ExaminationManagerService;
import hu.jusoft.gerevet.service.ListingExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Service
public class ExaminationManagerServiceImpl implements ExaminationManagerService {

    @Autowired
    private ListingExaminationService listingExaminationServiceService;

    @Autowired
    private ExaminationRepositoryCustom examinationRepositoryCustom;

    @Autowired
    private ExaminationRepository examinationRepository;

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Override
    public ExaminationPageModel getActualExaminationFromId(String examinationId) {
        List<ExaminationPageModel> listOfExamination = listingExaminationServiceService.getListOfExaminations();
        ExaminationPageModel resultExamination = new ExaminationPageModel();

        for (int i = 0; i < listOfExamination.size(); i++) {
            if (examinationId.equals(listOfExamination.get(i).getId())) {
                resultExamination = listOfExamination.get(i);
                break;
            }
        }

        return resultExamination;
    }

    @Override
    public Examination findExaminationByExaminationId(String id) {
        return examinationRepository.findOne(id);
    }

    @Override
    public void addImageToExamination(Examination examination, ExaminationFile examinationFile, boolean isPicture) {
        String fileId = examinationRepositoryCustom.addImageToExamination(examination.getId(), examinationFile);

        if (isPicture) {
            if (examination.getPictures() == null) {
                examination.setPictures(new ArrayList<FileData>());
            }
            examination.getPictures().add(new FileData(examinationFile.getName(), fileId));
        } else {
            if (examination.getDocuments() == null) {
                examination.setDocuments(new ArrayList<FileData>());
            }
            examination.getDocuments().add(new FileData(examinationFile.getName(), fileId));
        }

        examinationRepository.save(examination);
    }

    @Override
    public GridFSDBFile findImageById(String id) {
        return gridFsTemplate.findOne(new Query(Criteria.where("_id").is(
                id)));
    }

    @Override
    public Examination save(Examination examination) {
        return examinationRepository.save(examination);
    }
}
