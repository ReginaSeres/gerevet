package hu.jusoft.gerevet.service;

import hu.jusoft.gerevet.domain.model.Animal;
import org.springframework.stereotype.Service;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Service
public interface AnimalManagerService {
    Animal getActualAnimal(String actualAnimalId);
}
