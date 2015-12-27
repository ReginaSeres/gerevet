package hu.jusoft.gerevet.service.impl;

import hu.jusoft.gerevet.repository.model.Examination;
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
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Service
public class ExaminationManagerServiceImpl implements ExaminationManagerService {

    @Autowired
    private ListingExaminationService listingExaminationServiceService;

    @Autowired
    private ExaminationRepository examinationRepository;

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
    public Examination findOne(String id) {
        return examinationRepository.findOne(id);
    }
}
