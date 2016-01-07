package hu.jusoft.gerevet.repository;

import hu.jusoft.gerevet.repository.model.Examination;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Regina Seres on 12/13/2015.
 */
public interface ExaminationRepository extends MongoRepository<Examination, String> {

}
