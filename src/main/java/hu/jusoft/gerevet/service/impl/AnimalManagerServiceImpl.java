package hu.jusoft.gerevet.service.impl;

import hu.jusoft.gerevet.repository.AnimalRepository;
import hu.jusoft.gerevet.repository.PatientRepository;
import hu.jusoft.gerevet.repository.model.Animal;
import hu.jusoft.gerevet.repository.model.Patient;
import hu.jusoft.gerevet.service.builder.AnimalBuilder;
import hu.jusoft.gerevet.view.model.AnimalPageModel;
import hu.jusoft.gerevet.service.AnimalManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Service
public class AnimalManagerServiceImpl implements AnimalManagerService{

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AnimalBuilder animalBuilder;

    private static final String ID_SEPARATE_STRING = "-";

    @Override
    public Animal findAnimalByPatientIdAndAnimalId(String actAnimalId) {
        String patientId = actAnimalId.split(ID_SEPARATE_STRING)[0];
        String animalId = actAnimalId.split(ID_SEPARATE_STRING)[1];

        return animalRepository.findAnimalByPatientIdAndAnimalId(patientId, animalId);
    }

    @Override
    public String save(AnimalPageModel animalPageModel) {
        Patient patient = patientRepository.findOne(animalPageModel.getPatient());

        Animal animal = animalBuilder.buildFromPageModel(animalPageModel, "5");

        patient.getAnimal().add(animal);

        patientRepository.save(patient);

        return patient.getId() + ID_SEPARATE_STRING + animal.getAnimalId();
    }
}
