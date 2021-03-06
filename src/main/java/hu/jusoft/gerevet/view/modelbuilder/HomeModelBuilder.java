package hu.jusoft.gerevet.view.modelbuilder;

import hu.jusoft.gerevet.repository.model.Animal;
import hu.jusoft.gerevet.repository.model.Examination;
import hu.jusoft.gerevet.view.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.*;

import static hu.jusoft.gerevet.controller.ControllerConstants.*;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Component
public class HomeModelBuilder {

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

        model.put(LIST_OF_EXAMINATIONS, homePageModelList);
        model.put(EXAMINATIONS_PAGE_COUNT, examinations.getTotalPages());
        model.put(URL, SEARCH_PARAMETERIZED_URL);
        model.put(EXAMINATIONS_ACT_PAGE, examinations.getNumber() + 1);
        model.put(EXAMINATION_QUERY_NAME, queryName);

        return model;
    }
}
