package hu.jusoft.gerevet.validator;

import hu.jusoft.gerevet.view.model.NewExaminationPageModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

/**
 * Created by Regina Seres on 1/8/2016.
 */
@Component("examinationValidator")
public class NewExaminationPageModelValidator implements Validator {

    private static final String DEFAULT_EXAMINATION_PATIENT_ID = "-1";

    @Override
    public boolean supports(Class<?> clazz) {
        return NewExaminationPageModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewExaminationPageModel newExaminationPageModel = (NewExaminationPageModel) target;

        if (newExaminationPageModel.getPatientId() == null ||
                "".equals(newExaminationPageModel.getPatientId()) ||
                DEFAULT_EXAMINATION_PATIENT_ID.equals(newExaminationPageModel.getPatientId())) {
            errors.reject("patientId", "validator.newExamination.patientIdError");
        }

        if (newExaminationPageModel.getAnimalId() == null ||
                "".equals(newExaminationPageModel.getAnimalId())) {
            errors.reject("animalId", "validator.newExamination.animalIdError");
        }

        if (new BigDecimal(0).equals(newExaminationPageModel.getInvoiceId())) {
            errors.reject("invoiceId", "validator.newExamination.invoiceIdError");
        }
    }
}
