package hu.jusoft.gerevet.service.impl;

import hu.jusoft.gerevet.domain.model.Examination;
import hu.jusoft.gerevet.service.ExaminationManagerService;
import hu.jusoft.gerevet.service.ListingExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Service
public class ExaminationManagerServiceImpl implements ExaminationManagerService {

    @Autowired
    private ListingExaminationService listingExaminationServiceService;

    @Override
    public Examination getActualExaminationFromId(String examinationId) {
        List<Examination> listOfExamination = listingExaminationServiceService.getListOfExaminations();
        Examination resultExamination = new Examination();

        for (int i = 0; i < listOfExamination.size(); i++) {
            if (examinationId.equals(listOfExamination.get(i).getId())) {
                resultExamination = listOfExamination.get(i);
                break;
            }
        }

        return resultExamination;
    }
}
