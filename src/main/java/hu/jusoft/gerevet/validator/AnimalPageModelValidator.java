package hu.jusoft.gerevet.validator;

import hu.jusoft.gerevet.view.model.AnimalPageModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Regina Seres on 1/8/2016.
 */
@Component("animalValidator")
public class AnimalPageModelValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return AnimalPageModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AnimalPageModel animalPageModel = (AnimalPageModel) target;

        if (animalPageModel.getName()== null || "".equals(animalPageModel.getName())) {
            errors.reject("name", "validator.animal.nameError");
        }

        if (animalPageModel.getSpecies() == null || "".equals(animalPageModel.getSpecies())) {
            errors.reject("species", "validator.animal.speciesError");
        }
    }
}
