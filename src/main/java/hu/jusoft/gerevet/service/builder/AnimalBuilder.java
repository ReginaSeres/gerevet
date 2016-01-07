package hu.jusoft.gerevet.service.builder;

import hu.jusoft.gerevet.repository.model.Animal;
import hu.jusoft.gerevet.view.model.AnimalPageModel;
import org.springframework.stereotype.Component;

/**
 * Created by Regina Seres on 12/27/2015.
 */
@Component
public class AnimalBuilder {

    public Animal buildFromPageModel(AnimalPageModel animalPageModel, String id) {
        return new Animal(id,
                animalPageModel.getName(),
                animalPageModel.getSpecies(),
                animalPageModel.getBreed(),
                animalPageModel.getSex(),
                animalPageModel.getAge());
    }
}
