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

    @RequestMapping("/animal/{actAnimal}")
    public ModelAndView indexSearch(@PathVariable("actAnimal") String actAnimalId, Model model, Locale locale) {
        Animal animal = animalManagerService.findAnimalByPatientIdAndAnimalId(actAnimalId);

        ModelAndView mav = new ModelAndView("animal");
        mav.addAllObjects(animalModelBuilder.buildPatientModelMap(animal));

        return mav;
    }

    @RequestMapping("/addAnimal")
    public ModelAndView addPatient() {
        List<Patient> listOfPatients = patientManagerService.findAllPatient();

        ModelAndView mav = new ModelAndView("addAnimal");
        mav.addAllObjects(patientModelBuilder.buildPatientModelMap(listOfPatients));

        return mav;
    }

    @RequestMapping(value = "/saveAnimal", method = RequestMethod.POST)
    public void savePatient(
            @ModelAttribute("animalPageModel") AnimalPageModel animalPageModel, HttpServletResponse response) throws IOException {
        animalManagerService.save(animalPageModel);
         System.out.println("fut");
        response.sendRedirect("/addAnimal/");
    }

    @ResponseBody
    @RequestMapping(value = {"/updateAnimal"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public AnimalPageModel updateAnimal(@RequestBody AnimalPageModel animal) {
        return animal;
    }
}
