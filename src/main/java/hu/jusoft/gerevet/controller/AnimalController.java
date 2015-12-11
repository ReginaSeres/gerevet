package hu.jusoft.gerevet.controller;

import hu.jusoft.gerevet.domain.model.Animal;
import hu.jusoft.gerevet.service.AnimalManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Controller
public class AnimalController {

    @Autowired
    private AnimalManagerService animalManagerService;

    @RequestMapping(value = {"/animal/{actAnimal}"})
    public String indexSearch(@PathVariable("actAnimal") String actAnimal, Model model, Locale locale) {
        Animal actualAnimal = animalManagerService.getActualAnimal(actAnimal);

        model.addAttribute("animal", actualAnimal);

        return "animal";
    }
}
