package hu.jusoft.gerevet.service.impl;

import hu.jusoft.gerevet.domain.model.Animal;
import hu.jusoft.gerevet.domain.model.Examination;
import hu.jusoft.gerevet.service.AnimalManagerService;
import hu.jusoft.gerevet.service.ListingExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Service
public class AnimalManagerServiceImpl implements AnimalManagerService{

    @Autowired
    private ListingExaminationService listingExaminationService;

    @Override
    public Animal getActualAnimal(String actualAnimalId) {
        List<Examination> listOfExaminations = listingExaminationService.getListOfExaminations();
        Animal actualAnimal = new Animal();
        for (int i = 0; i <listOfExaminations.size(); i++) {
            if (actualAnimalId.equals(listOfExaminations.get(i).getAnimal().getId())) {
                actualAnimal = listOfExaminations.get(i).getAnimal();
                break;
            }
        }

        return actualAnimal;
    }
}
