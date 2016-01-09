package hu.jusoft.gerevet.service;

import hu.jusoft.gerevet.repository.model.Animal;
import hu.jusoft.gerevet.view.model.AnimalPageModel;
import org.springframework.stereotype.Service;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Service
public interface AnimalManagerService {

    Animal findAnimalByPatientIdAndAnimalId(String actAnimalId);

    String save(AnimalPageModel animalPageModel);

}