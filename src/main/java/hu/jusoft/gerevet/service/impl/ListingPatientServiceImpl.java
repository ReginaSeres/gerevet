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

    @PostConstruct
    public void setListOfPatient() {
        listOfPatient.add(new PatientPageModel("1", "Kis Janos1", "Petofi utca 3", "6000 Kecskemet", "000000000", "kis.janos@gmail.com"));
        listOfPatient.add(new PatientPageModel("2", "Kis Janos2", "", "6000 Kecskemet", "000000000", "kis.janos@gmail.com"));
        listOfPatient.add(new PatientPageModel("3", "Kis Janos3", "Petofi utca 3", "6000 Kecskemet", "000000000", "kis.janos@gmail.com"));
        listOfPatient.add(new PatientPageModel("4", "Kis Janos4", "Petofi utca 3", "6000 Kecskemet", "", "kis.janos@gmail.com"));
        listOfPatient.add(new PatientPageModel("5", "Kis Janos5", "Petofi utca 3", "6000 Kecskemet", "000000000", ""));
        listOfPatient.add(new PatientPageModel("6", "Kis Janos6", "Petofi utca 3", "6000 Kecskemet", "000000000", "kis.janos@gmail.com"));
        listOfPatient.add(new PatientPageModel("7", "Kis Janos7", "Petofi utca 3", "", "000000000", "kis.janos@gmail.com"));
        listOfPatient.add(new PatientPageModel("8", "Kis Janos8", "Petofi utca 3", "6000 Kecskemet", "000000000", "kis.janos@gmail.com"));
        listOfPatient.add(new PatientPageModel("9", "Kis Janos9", "", "", "", ""));
        listOfPatient.add(new PatientPageModel("10", "Kis Janos10", "Petofi utca 3", "6000 Kecskemet", "000000000", "kis.janos@gmail.com"));
    }

    //what does actPage mean?
    @Override
    public List<PatientPageModel> getTenPatientFromActualPage(int actPage) {
        List<PatientPageModel> listOfTenPatient = new ArrayList<>();

        for (int i = (actPage - 1) * ITEMS_PER_PAGE, count = 0; i < listOfPatient.size() || count < ITEMS_PER_PAGE; i++, count++) {
            //use listOfPatient.sublist method instead, you can give a start index and an end index and generates the result list for you :)
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
    public List<PatientPageModel> getListOfPatientFromQuery(String query) {
        //you can use CollectionUtils.filter (probably)
        //or https://code.google.com/p/google-collections/ check this google guava library it has a lot nice features

        List<PatientPageModel> listOfPatientFromQuery = new ArrayList<PatientPageModel>();
        for (int i = 0; i < listOfPatient.size(); i++) {
            if (query.equals(listOfPatient.get(i).getName())) {
                listOfPatientFromQuery.add(listOfPatient.get(i));
            }
        }
        return listOfPatientFromQuery;
    }

    @Override
    public List<PatientPageModel> getListOfPatient() {
        return new ArrayList<>(listOfPatient);
    }
}
