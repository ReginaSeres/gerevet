package hu.jusoft.gerevet.controller;

import hu.jusoft.gerevet.repository.model.Animal;
import hu.jusoft.gerevet.repository.model.Patient;
import hu.jusoft.gerevet.service.PatientManagerService;
import hu.jusoft.gerevet.view.model.AnimalPageModel;
import hu.jusoft.gerevet.service.AnimalManagerService;
import hu.jusoft.gerevet.view.modelbuilder.AnimalModelBuilder;
import hu.jusoft.gerevet.view.modelbuilder.PatientModelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static hu.jusoft.gerevet.controller.ControllerConstants.*;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Controller
public class AnimalController {

    @Autowired
    private AnimalManagerService animalManagerService;

    @Autowired
    private AnimalModelBuilder animalModelBuilder;

    @Autowired
    private PatientModelBuilder patientModelBuilder;

    @Autowired
    private PatientManagerService patientManagerService;

    @RequestMapping(value = ANIMAL_PARAMETERIZED_URL)
    public ModelAndView indexSearch(@PathVariable(ANIMAL_INDEX_VARIABLE) String actAnimalId, Model model, Locale locale) {
        Animal animal = animalManagerService.findAnimalByPatientIdAndAnimalId(actAnimalId);

        ModelAndView mav = new ModelAndView(ANIMAL);
        mav.addAllObjects(animalModelBuilder.buildAnimalModelMap(animal));

        return mav;
    }

    @RequestMapping(value = ADD_ANIMAL_URL)
    public ModelAndView addPatient() {
        List<Patient> listOfPatients = patientManagerService.findAllPatient();

        ModelAndView mav = new ModelAndView(ADD_ANIMAL);
        mav.addAllObjects(patientModelBuilder.buildPatientModelMap(listOfPatients));

        return mav;
    }

    @RequestMapping(value = SAVE_ANIMAL_URL, method = RequestMethod.POST)
    public void savePatient(
            @ModelAttribute(ANIMAL_PAGE_MODEL_NAME) AnimalPageModel animalPageModel, HttpServletResponse response) throws IOException {
        animalManagerService.save(animalPageModel);
        response.sendRedirect(ADD_ANIMAL);
    }

    @ResponseBody
    @RequestMapping(value = {UPDATE_ANIMAL_URL}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public AnimalPageModel updateAnimal(@RequestBody AnimalPageModel animal) {
        return animal;
    }
}
