package hu.jusoft.gerevet.view.modelbuilder;

import com.google.common.collect.Iterables;
import hu.jusoft.gerevet.repository.model.Animal;
import hu.jusoft.gerevet.view.model.AnimalPageModel;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Regina Seres on 12/15/2015.
 */
@Component
public class AnimalModelBuilder {

    public Map<String,Object> buildPatientModelMap(Animal animal) {
        AnimalPageModel animalPageModel = build(animal);

        Map<String, Object> model = new HashMap<>();
        model.put("animal", animalPageModel);
        model.put("editJS", "editJS");

        return model;
    }

    public AnimalPageModel build(List<Animal> animals) {
        return build(Iterables.getOnlyElement(animals));
    }

    private AnimalPageModel build(Animal animal) {
        return new AnimalPageModel(animal.getAnimalId(), animal.getName(), animal.getSpecies(), animal.getBreed(), animal.getSex(), animal.getAge());
    }
}
