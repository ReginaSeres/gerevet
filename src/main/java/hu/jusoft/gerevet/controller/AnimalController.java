package hu.jusoft.gerevet.controller;

import hu.jusoft.gerevet.domain.model.Animal;
import hu.jusoft.gerevet.domain.model.Patient;
import hu.jusoft.gerevet.service.AnimalManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Controller
public class AnimalController {

    @Autowired
    private AnimalManagerService animalManagerService;

    @RequestMapping("/animal/{actAnimal}")
    public String indexSearch(@PathVariable("actAnimal") String actAnimal, Model model, Locale locale) {
        Animal actualAnimal = animalManagerService.getActualAnimal(actAnimal);

        model.addAttribute("animal", actualAnimal);
        model.addAttribute("editJS", "editJS");

        return "animal";
    }

    @ResponseBody
    @RequestMapping(value = {"/updateAnimal"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Animal updateAnimal(@RequestBody Animal animal) {
        return animal;
    }
}
