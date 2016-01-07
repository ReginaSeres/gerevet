package hu.jusoft.gerevet.view.modelbuilder;

import hu.jusoft.gerevet.repository.model.*;
import hu.jusoft.gerevet.view.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static hu.jusoft.gerevet.controller.ControllerConstants.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Component
public class ExaminationModelBuilder {

    @Autowired
    private PatientModelBuilder patientModelBuilder;

    @Autowired
    private AnimalModelBuilder animalModelBuilder;

    @Autowired
    private InvoiceModelBuilder invoiceModelBuilder;

    public Map<String,Object> buildExaminationMap(Examination examination) {
        Map<String, Object> model = new HashMap<>();
        PatientPageModel patientPageModel = patientModelBuilder.build(examination.getPatient());
        List<Animal> animals = examination.getPatient().getAnimal();

        AnimalPageModel animalPageModel = animalModelBuilder.build(animals);

        InvoicePageModel invoicePageModel = invoiceModelBuilder.build(examination.getInvoice());

        ExaminationPageModel examinationPageModel = new ExaminationPageModel(
                examination.getId(), patientPageModel, animalPageModel, invoicePageModel,
                examination.getPictures(), examination.getDocuments(), examination.getExaminationDate(),
                examination.getSymptom(), examination.getExamination(), examination.getComment(),
                examination.getBruttoPrice());

        model.put(EXAMINATION, examinationPageModel);

        return model;
    }

    public Examination buildExaminationMap(NewExaminationPageModel examinationPageModel) {
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal(examinationPageModel.getAnimalId(),
                examinationPageModel.getAnimalName(),
                examinationPageModel.getAnimalSpecies(),
                examinationPageModel.getAnimalBreed(),
                examinationPageModel.getAnimalSex(),
                examinationPageModel.getAnimalAge()));

        Patient patient = new Patient(examinationPageModel.getPatientId(),
                examinationPageModel.getPatientName(),
                examinationPageModel.getPatientAddress(),
                examinationPageModel.getPatientCity(),
                examinationPageModel.getPatientPhoneNumber(),
                examinationPageModel.getPatientEmailAddress(), animalList);

        Invoice invoice = new Invoice(examinationPageModel.getInvoiceId(),
                examinationPageModel.getInvoiceDate(),
                examinationPageModel.getInvoicePaymentDeadline(),
                examinationPageModel.getInvoiceDayOfPayment(),
                examinationPageModel.getInvoiceGroups());

        Examination examination = new Examination(examinationPageModel.getPatientId(),
                examinationPageModel.getAnimalId(),
                examinationPageModel.getExaminationDate(),
                examinationPageModel.getExaminationSymptom(),
                examinationPageModel.getExaminationExamination(),
                examinationPageModel.getExaminationComment(),
                new BigDecimal(0),
                new ArrayList<FileData>(), new ArrayList<FileData>(),
                invoice,
                patient);

        return examination;
    }
}
