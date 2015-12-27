package hu.jusoft.gerevet.view.modelbuilder;

import hu.jusoft.gerevet.repository.model.Animal;
import hu.jusoft.gerevet.repository.model.Examination;
import hu.jusoft.gerevet.view.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
                new PicturesPageModel(), examination.getExaminationDate(),
                examination.getSymptom(), examination.getExamination(), examination.getComment(),
                examination.getBruttoPrice());

        model.put("examination", examinationPageModel);
        return model;
    }
}
