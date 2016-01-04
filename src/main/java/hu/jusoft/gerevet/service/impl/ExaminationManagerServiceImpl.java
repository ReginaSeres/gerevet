package hu.jusoft.gerevet.service.impl;

import com.mongodb.gridfs.GridFSDBFile;
import hu.jusoft.gerevet.repository.ExaminationRepositoryCustom;
import hu.jusoft.gerevet.repository.model.Examination;
import hu.jusoft.gerevet.repository.model.Picture;
import hu.jusoft.gerevet.view.model.ExaminationPageModel;
import hu.jusoft.gerevet.repository.ExaminationRepository;
import hu.jusoft.gerevet.repository.PatientRepository;
import hu.jusoft.gerevet.repository.model.Patient;
import hu.jusoft.gerevet.service.ExaminationManagerService;
import hu.jusoft.gerevet.service.ListingExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
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
    public void addImageToExamination(String examinationId, Picture picture) {
        examinationId = "566f091306583586f8ed32c7";
        String pictureId = examinationRepositoryCustom.addImageToExamination(examinationId, picture);

        Examination examination = examinationRepository.findOne(examinationId);

        if (examination.getPictures() == null) {
            examination.setPictures(new ArrayList<String>());
        }
        examination.getPictures().add(pictureId);

        examinationRepository.save(examination);
    }

    @Override
    public GridFSDBFile findImageById(String id) {
        return gridFsTemplate.findOne(new Query(Criteria.where("_id").is(
                id)));
    }
}
