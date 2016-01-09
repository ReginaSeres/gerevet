package hu.jusoft.gerevet.controller;

import hu.jusoft.gerevet.repository.model.Animal;
import hu.jusoft.gerevet.repository.model.Patient;
import hu.jusoft.gerevet.service.PatientManagerService;
import hu.jusoft.gerevet.validator.AnimalPageModelValidator;
import hu.jusoft.gerevet.view.model.AnimalPageModel;
import hu.jusoft.gerevet.service.AnimalManagerService;
import hu.jusoft.gerevet.view.modelbuilder.AnimalModelBuilder;
import hu.jusoft.gerevet.view.modelbuilder.PatientModelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

import static hu.jusoft.gerevet.controller.ControllerConstants.*;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Controller
public class AnimalController {

    @Autowired
    private MessageSource msg;

    @Autowired
    private AnimalManagerService animalManagerService;

    @Autowired
    private AnimalModelBuilder animalModelBuilder;

    @Autowired
    private PatientModelBuilder patientModelBuilder;

    @Autowired
    private PatientManagerService patientManagerService;

    @Autowired
    private AnimalPageModelValidator animalPageModelValidator;

    @InitBinder(ANIMAL_PAGE_MODEL_NAME)
    public void initEUSearchBinder(WebDataBinder binder) {
        binder.addValidators(animalPageModelValidator);
    }

    @RequestMapping(value = ANIMAL_PARAMETERIZED_URL)
    public ModelAndView indexSearch(@PathVariable(ANIMAL_INDEX_VARIABLE) String actAnimalId) {
        Animal animal = animalManagerService.findAnimalByPatientIdAndAnimalId(actAnimalId);

        ModelAndView mav = new ModelAndView(ANIMAL);
        mav.addAllObjects(animalModelBuilder.buildAnimalModelMap(animal));

        return mav;
    }

    @RequestMapping(value = ADD_ANIMAL_URL)
    public ModelAndView addPatient(@RequestParam(value = "animalListIsEmpty", required = false, defaultValue = "") String patientId,
                                   Locale locale) {
        List<Patient> listOfPatients = patientManagerService.findAllPatient();

        if (listOfPatients.size() == 0) {
            return new ModelAndView("redirect:" + ADD_PATIENT_URL + "?patientListIsEmpty=true");
        }

        Map<String, Object> model = new HashMap<>();
        model.put("patientId", patientId);

        if (!"".equals(patientId)) {
            List<String> errorList = new ArrayList<>();
            errorList.add(msg.getMessage("animal.add.animal_list_is_empty", null, locale));
            model.put("errorList", errorList);
        }

        ModelAndView mav = new ModelAndView(ADD_ANIMAL);
        mav.addAllObjects(patientModelBuilder.buildPatientModelMap(listOfPatients));
        mav.addAllObjects(model);

        return mav;
    }

    @RequestMapping(value = ADD_ANIMAL_URL, method = RequestMethod.POST)
    public ModelAndView savePatient(
            @Valid @ModelAttribute(ANIMAL_PAGE_MODEL_NAME) AnimalPageModel animalPageModel, BindingResult bindingResult, Locale locale) throws IOException {
        if (bindingResult.hasErrors()) {
            List<String> errorList = new ArrayList<>();
            for (ObjectError oe : bindingResult.getGlobalErrors()) {
                errorList.add(msg.getMessage(oe.getDefaultMessage(), null, locale));
            }
            Map<String, Object> model = new HashMap<>();
            model.put("errorList", errorList);

            ModelAndView mav = new ModelAndView(ADD_PATIENT);
            mav.addAllObjects(model);

            return mav;
        }

        String id = animalManagerService.save(animalPageModel);
        return new ModelAndView("redirect:" + ANIMAL_URL + "/" + id);
    }

    @ResponseBody
    @RequestMapping(value = {UPDATE_ANIMAL_URL}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public AnimalPageModel updateAnimal(@RequestBody AnimalPageModel animal) {
        return animal;
    }
}
