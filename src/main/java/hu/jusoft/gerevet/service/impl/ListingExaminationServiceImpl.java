package hu.jusoft.gerevet.service.impl;

import hu.jusoft.gerevet.domain.model.*;
import hu.jusoft.gerevet.service.ListingExaminationService;
import hu.jusoft.gerevet.service.ListingPatientService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private List<Examination> listOfExaminations = new ArrayList<>();

    @Autowired
    private ListingPatientService listingPatientService;

    @Override
    public List<Examination> getTenExaminationFromActualPage(int actPage) {
        int startIndex = (actPage - 1) * ITEMS_PER_PAGE;
        int endIndex = calculateEndIndex(startIndex);
        return listOfExaminations.subList(startIndex, endIndex);
    }

    @Override
    public int getPagesCount() {
        int pagesCount = listOfExaminations.size() / ITEMS_PER_PAGE;
        if (listOfExaminations.size() % ITEMS_PER_PAGE != 0) pagesCount++;
        return pagesCount;
    }

    @Override
    public List<Examination> getListOfExaminations() {
        return new ArrayList<>(listOfExaminations);
    }

    @Override
    public List<Examination> getListOfExaminationsForActualPatientId(String actualPatientId) {
        List<Examination> listOfExaminationsForActualPatientId = new ArrayList<>();

        for (int i = 0; i < listOfExaminations.size(); i++ ) {
            if (actualPatientId.equals(listOfExaminations.get(i).getPatient().getId())) {
                listOfExaminationsForActualPatientId.add(listOfExaminations.get(i));
            }
        }

        return listOfExaminationsForActualPatientId;
    }

    @PostConstruct
    private void setListOfPatient() {
        List<Animal> listOfAnimals = new ArrayList<>();
        listOfAnimals.add(new Animal("1", getPatientFromPatientId("1"), "Kicsi", "Faj neve", "Fajta neve", "nem", 2));
        listOfAnimals.add(new Animal("2", getPatientFromPatientId("2"), "Kicsi", "Faj neve", "Fajta neve", "nem", 2));
        listOfAnimals.add(new Animal("3", getPatientFromPatientId("3"), "Kicsi", "Faj neve", "Fajta neve", "nem", 2));
        listOfAnimals.add(new Animal("4", getPatientFromPatientId("1"), "Kicsi", "Faj neve", "Fajta neve", "nem", 2));
        listOfAnimals.add(new Animal("5", getPatientFromPatientId("2"), "Kicsi", "Faj neve", "Fajta neve", "nem", 2));
        listOfAnimals.add(new Animal("6", getPatientFromPatientId("3"), "Kicsi", "Faj neve", "Fajta neve", "nem", 2));
        listOfAnimals.add(new Animal("7", getPatientFromPatientId("1"), "Kicsi", "Faj neve", "Fajta neve", "nem", 2));
        listOfAnimals.add(new Animal("8", getPatientFromPatientId("2"), "Kicsi", "Faj neve", "Fajta neve", "nem", 2));
        listOfAnimals.add(new Animal("9", getPatientFromPatientId("3"), "Kicsi", "Faj neve", "Fajta neve", "nem", 2));
        listOfAnimals.add(new Animal("10", getPatientFromPatientId("1"), "Kicsi", "Faj neve", "Fajta neve", "nem", 2));

        List<Invoice> listOfInvoices = new ArrayList<>();
        listOfInvoices.add(new Invoice("1", new Date(), new Date(), new Date()));
        listOfInvoices.add(new Invoice("2", new Date(), new Date(), new Date()));
        listOfInvoices.add(new Invoice("3", new Date(), new Date(), new Date()));
        listOfInvoices.add(new Invoice("4", new Date(), new Date(), new Date()));
        listOfInvoices.add(new Invoice("5", new Date(), new Date(), new Date()));
        listOfInvoices.add(new Invoice("6", new Date(), new Date(), new Date()));
        listOfInvoices.add(new Invoice("7", new Date(), new Date(), new Date()));
        listOfInvoices.add(new Invoice("8", new Date(), new Date(), new Date()));
        listOfInvoices.add(new Invoice("9", new Date(), new Date(), new Date()));
        listOfInvoices.add(new Invoice("10", new Date(), new Date(), new Date()));


        listOfExaminations.add(new Examination("1", getPatientFromPatientId("1"), listOfAnimals.get(0), listOfInvoices.get(0), new Pictures(), new Date(), "Ide kerulnek a tunetek leirasa", "Ide a kezeles", "Ide pedig a komment", 500));
        listOfExaminations.add(new Examination("2", getPatientFromPatientId("2"), listOfAnimals.get(1), listOfInvoices.get(1), new Pictures(), new Date(), "Ide kerulnek a tunetek leirasa", "Ide a kezeles", "Ide pedig a komment", 500));
        listOfExaminations.add(new Examination("3", getPatientFromPatientId("3"), listOfAnimals.get(2), listOfInvoices.get(2), new Pictures(), new Date(), "Ide kerulnek a tunetek leirasa", "Ide a kezeles", "Ide pedig a komment", 500));
        listOfExaminations.add(new Examination("4", getPatientFromPatientId("1"), listOfAnimals.get(3), listOfInvoices.get(3), new Pictures(), new Date(), "Ide kerulnek a tunetek leirasa", "Ide a kezeles", "Ide pedig a komment", 500));
        listOfExaminations.add(new Examination("5", getPatientFromPatientId("2"), listOfAnimals.get(4), listOfInvoices.get(4), new Pictures(), new Date(), "Ide kerulnek a tunetek leirasa", "Ide a kezeles", "Ide pedig a komment", 500));
        listOfExaminations.add(new Examination("6", getPatientFromPatientId("3"), listOfAnimals.get(5), listOfInvoices.get(5), new Pictures(), new Date(), "Ide kerulnek a tunetek leirasa", "Ide a kezeles", "Ide pedig a komment", 500));
        listOfExaminations.add(new Examination("7", getPatientFromPatientId("1"), listOfAnimals.get(6), listOfInvoices.get(6), new Pictures(), new Date(), "Ide kerulnek a tunetek leirasa", "Ide a kezeles", "Ide pedig a komment", 500));
        listOfExaminations.add(new Examination("8", getPatientFromPatientId("2"), listOfAnimals.get(7), listOfInvoices.get(7), new Pictures(), new Date(), "Ide kerulnek a tunetek leirasa", "Ide a kezeles", "Ide pedig a komment", 500));
        listOfExaminations.add(new Examination("9", getPatientFromPatientId("3"), listOfAnimals.get(8), listOfInvoices.get(8), new Pictures(), new Date(), "Ide kerulnek a tunetek leirasa", "Ide a kezeles", "Ide pedig a komment", 500));
        listOfExaminations.add(new Examination("10", getPatientFromPatientId("1"), listOfAnimals.get(9), listOfInvoices.get(9), new Pictures(), new Date(), "Ide kerulnek a tunetek leirasa", "Ide a kezeles", "Ide pedig a komment", 500));
    }

    private Patient getPatientFromPatientId(String patientId) {
        List<Patient> listOfPatients = listingPatientService.getListOfPatient();
        for (int i = 0; i < listOfPatients.size(); i++) {
            if (patientId.equals(listOfPatients.get(i).getId())) {
                return listOfPatients.get(i);
            }
        }
        return new Patient();
    }

    private int calculateEndIndex(int startIndex) {
        int endIndex = (startIndex + ITEMS_PER_PAGE);
        if (endIndex >= listOfExaminations.size()) {
            endIndex = listOfExaminations.size();
        }
        return  endIndex;
    }
}
