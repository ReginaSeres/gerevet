package hu.jusoft.gerevet.service.impl;

import hu.jusoft.gerevet.domain.model.Patient;
import hu.jusoft.gerevet.domain.model.Treatment;
import hu.jusoft.gerevet.service.ListingPatientService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Regina Seres on 12/10/2015.
 */
@Service
public class ListingPatientServiceImpl implements ListingPatientService {

    List<Patient> listOfPatient = new ArrayList<Patient>();

    @PostConstruct
    public void setListOfPatient() {
        List<Treatment> listOfTreatmentForPatient = new ArrayList<Treatment>();
        listOfTreatmentForPatient.add(new Treatment("1", "1", new Date(), "Ide kerulnek a tunetek leirasa", "Ide a kezeles", "Ide pedig a komment"));
        listOfTreatmentForPatient.add(new Treatment("2", "1", new Date(), "Ide kerulnek a tunetek leirasa", "Ide a kezeles", "Ide pedig a komment"));
        listOfTreatmentForPatient.add(new Treatment("3", "1", new Date(), "Ide kerulnek a tunetek leirasa", "Ide a kezeles", "Ide pedig a komment"));
        listOfTreatmentForPatient.add(new Treatment("4", "1", new Date(), "Ide kerulnek a tunetek leirasa", "Ide a kezeles", "Ide pedig a komment"));
        listOfTreatmentForPatient.add(new Treatment("5", "1", new Date(), "Ide kerulnek a tunetek leirasa", "Ide a kezeles", "Ide pedig a komment"));

        listOfPatient.add(new Patient("1", "Kis Janos1", "Petofi utca 3", "6000 Kecskemet", "000000000", "kis.janos@gmail.com", listOfTreatmentForPatient));
        listOfPatient.add(new Patient("2", "Kis Janos2", "", "6000 Kecskemet", "000000000", "kis.janos@gmail.com", null));
        listOfPatient.add(new Patient("3", "Kis Janos3", "Petofi utca 3", "6000 Kecskemet", "000000000", "kis.janos@gmail.com", null));
        listOfPatient.add(new Patient("4", "Kis Janos4", "Petofi utca 3", "6000 Kecskemet", "", "kis.janos@gmail.com", null));
        listOfPatient.add(new Patient("5", "Kis Janos5", "Petofi utca 3", "6000 Kecskemet", "000000000", "", null));
        listOfPatient.add(new Patient("6", "Kis Janos6", "Petofi utca 3", "6000 Kecskemet", "000000000", "kis.janos@gmail.com", null));
        listOfPatient.add(new Patient("7", "Kis Janos7", "Petofi utca 3", "", "000000000", "kis.janos@gmail.com", null));
        listOfPatient.add(new Patient("8", "Kis Janos8", "Petofi utca 3", "6000 Kecskemet", "000000000", "kis.janos@gmail.com", null));
        listOfPatient.add(new Patient("9", "Kis Janos9", "", "", "", "", null));
        listOfPatient.add(new Patient("10", "Kis Janos10", "Petofi utca 3", "6000 Kecskemet", "000000000", "kis.janos@gmail.com", null));
    }

    @Override
    public List<Patient> getTenPatientFromActualPage(int actPage) {
        List<Patient> listOfTenPatient = new ArrayList<Patient>();

        for (int i = (actPage - 1) * 9, count = 0; i < listOfPatient.size(); i++, count++) {
            if (count == 9) continue;
            listOfTenPatient.add(listOfPatient.get(i));
        }

        return listOfTenPatient;
    }

    @Override
    public int getPagesCount() {
        int pagesCount = listOfPatient.size() / 9;
        if (listOfPatient.size() % 9 != 0) pagesCount++;
        return pagesCount;
    }

    @Override
    public List<Patient> getListOfPatientFromQuery(String query) {
        List<Patient> listOfPatientFromQuery = new ArrayList<Patient>();
        for (int i = 0; i < listOfPatient.size(); i++) {
            if (query.equals(listOfPatient.get(i).getName())) {
                listOfPatientFromQuery.add(listOfPatient.get(i));
            }
        }
        return listOfPatientFromQuery;
    }

    @Override
    public List<Patient> getListOfPatient() {
        return listOfPatient;
    }
}
