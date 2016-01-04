package hu.jusoft.gerevet.service.impl;

import hu.jusoft.gerevet.view.model.PatientPageModel;
import hu.jusoft.gerevet.service.ListingPatientService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Regina Seres on 12/10/2015.
 */
@Service
public class ListingPatientServiceImpl implements ListingPatientService {
    private List<PatientPageModel> listOfPatient = new ArrayList<>();

    private static final int ITEMS_PER_PAGE = 9;

    @Override
    public List<PatientPageModel> getTenPatientFromActualPage(int actPage) {
        List<PatientPageModel> listOfTenPatient = new ArrayList<>();

        for (int i = (actPage - 1) * ITEMS_PER_PAGE, count = 0; i < listOfPatient.size() || count < ITEMS_PER_PAGE; i++, count++) {
            listOfTenPatient.add(listOfPatient.get(i));
        }

        return listOfTenPatient;
    }

    @Override
    public int getPagesCount() {
        int pagesCount = listOfPatient.size() / ITEMS_PER_PAGE;
        if (listOfPatient.size() % ITEMS_PER_PAGE != 0) pagesCount++;
        return pagesCount;
    }

    @Override
    public List<PatientPageModel> getListOfPatient() {
        return new ArrayList<>(listOfPatient);
    }
}
