package hu.jusoft.gerevet.service.impl;

import hu.jusoft.gerevet.repository.model.Examination;
import hu.jusoft.gerevet.view.model.*;
import hu.jusoft.gerevet.view.model.AnimalPageModel;
import hu.jusoft.gerevet.view.model.ExaminationPageModel;
import hu.jusoft.gerevet.view.model.InvoicePageModel;
import hu.jusoft.gerevet.view.model.PatientPageModel;
import hu.jusoft.gerevet.repository.ExaminationRepository;
import hu.jusoft.gerevet.service.ListingExaminationService;
import hu.jusoft.gerevet.service.ListingPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Service
public class ListingExaminationServiceImpl implements ListingExaminationService {

    private static final int ITEMS_PER_PAGE = 9;

    private List<ExaminationPageModel> listOfExaminations = new ArrayList<>();

    @Autowired
    private ListingPatientService listingPatientService;

    @Autowired
    private ExaminationRepository examinationRepository;

    @Override
    public List<ExaminationPageModel> getListOfExaminations() {
        return new ArrayList<>(listOfExaminations);
    }

    @Override
    public List<ExaminationPageModel> getListOfExaminationsForActualPatientId(String actualPatientId) {
        List<ExaminationPageModel> listOfExaminationsForActualPatientId = new ArrayList<>();

        for (int i = 0; i < listOfExaminations.size(); i++ ) {
            if (actualPatientId.equals(listOfExaminations.get(i).getPatient().getId())) {
                listOfExaminationsForActualPatientId.add(listOfExaminations.get(i));
            }
        }

        return listOfExaminationsForActualPatientId;
    }

    @Override
    public Page<Examination> getNExamiationsInActualPage(int actPage, int countExaminationsOnOnePage) {
        return examinationRepository.findAll(new PageRequest(actPage, countExaminationsOnOnePage, Sort.Direction.DESC, "examinationDate"));
    }

    private PatientPageModel getPatientFromPatientId(String patientId) {
        List<PatientPageModel> listOfPatients = listingPatientService.getListOfPatient();
        for (int i = 0; i < listOfPatients.size(); i++) {
            if (patientId.equals(listOfPatients.get(i).getId())) {
                return listOfPatients.get(i);
            }
        }
        return new PatientPageModel();
    }

    private int calculateEndIndex(int startIndex) {
        int endIndex = (startIndex + ITEMS_PER_PAGE);
        if (endIndex >= listOfExaminations.size()) {
            endIndex = listOfExaminations.size();
        }
        return  endIndex;
    }
}
