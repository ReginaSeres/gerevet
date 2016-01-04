package hu.jusoft.gerevet.repository.impl;

import hu.jusoft.gerevet.repository.AnimalRepository;
import hu.jusoft.gerevet.repository.model.Animal;
import hu.jusoft.gerevet.repository.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

/**
 * Created by Regina Seres on 12/16/2015.
 */
@Repository
public class AnimalRepositoryImpl implements AnimalRepository {

    @Autowired
    private MongoOperations mongoOperations;

    public Animal findAnimalByPatientIdAndAnimalId(String patientId, String animalId) {
        Criteria findPatientCriteria = Criteria.where("_id").is(patientId);
        Criteria findAnimalCriteria = Criteria.where("animal").elemMatch(Criteria.where("animalId").is(animalId));
        BasicQuery query = new BasicQuery(findPatientCriteria.getCriteriaObject(), findAnimalCriteria.getCriteriaObject());

        Patient patient = mongoOperations.findOne(query, Patient.class);

        return patient.getAnimal().get(0);
    }
}
