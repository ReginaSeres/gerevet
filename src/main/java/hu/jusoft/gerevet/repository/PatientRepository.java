package hu.jusoft.gerevet.repository;

import hu.jusoft.gerevet.repository.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Regina Seres on 12/13/2015.
 */
public interface PatientRepository extends MongoRepository<Patient, String> {

    List<Patient> findByName(String name);
}
