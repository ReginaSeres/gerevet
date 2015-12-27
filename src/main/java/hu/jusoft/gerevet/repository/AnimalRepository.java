package hu.jusoft.gerevet.repository;

import hu.jusoft.gerevet.repository.model.Animal;

/**
 * Created by Regina Seres on 12/16/2015.
 */
public interface AnimalRepository {

    Animal findAnimalByPatientIdAndAnimalId(String patientId, String animalId);

}
