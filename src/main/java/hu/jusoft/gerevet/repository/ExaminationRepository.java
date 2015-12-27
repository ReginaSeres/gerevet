package hu.jusoft.gerevet.repository;

import hu.jusoft.gerevet.repository.model.Examination;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Regina Seres on 12/13/2015.
 */
public interface ExaminationRepository extends MongoRepository<Examination, String> {

}
