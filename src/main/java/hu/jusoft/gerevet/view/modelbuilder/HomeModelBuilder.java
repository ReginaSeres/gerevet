package hu.jusoft.gerevet.view.modelbuilder;

import hu.jusoft.gerevet.repository.model.Animal;
import hu.jusoft.gerevet.repository.model.Examination;
import hu.jusoft.gerevet.view.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Component
public class HomeModelBuilder {

    @Autowired
    private MessageSource msg;

    @Autowired
    private PatientModelBuilder patientModelBuilder;

    @Autowired
    private AnimalModelBuilder animalModelBuilder;

    @Autowired
    private InvoiceModelBuilder invoiceModelBuilder;

    public Map<String,Object> buildHomeModelMap(Page<Examination> examinations) {
        return buildHomeModelMap("", examinations);
    }

    public Map<String,Object> buildHomeModelMap(String queryName, Page<Examination> examinations) {
        Map<String, Object> model = new HashMap<>();
        List<ExaminationPageModel> homePageModelList = new ArrayList<>();

        for (Examination examination : examinations.getContent()) {
            PatientPageModel patientPageModel = patientModelBuilder.build(examination.getPatient());
            List<Animal> animals = examination.getPatient().getAnimal();
            AnimalPageModel animalPageModel = animalModelBuilder.build(animals);
            InvoicePageModel invoicePageModel = invoiceModelBuilder.build(examination.getInvoice());
            ExaminationPageModel examinationPageModel = new ExaminationPageModel(examination.getId(), patientPageModel, animalPageModel, invoicePageModel, examination.getExaminationDate(), examination.getBruttoPrice());
            homePageModelList.add(examinationPageModel);
        }

        model.put("listOfExaminations", homePageModelList);
        model.put("pageCount", examinations.getTotalPages());
        model.put("url", "/search/*");
        model.put("actPage", examinations.getNumber() + 1);
        model.put("queryName", queryName);

        return model;
    }
}
