package hu.jusoft.gerevet.validator;

import hu.jusoft.gerevet.view.model.PatientPageModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Regina Seres on 1/8/2016.
 */
@Component("patientValidator")
public class PatientPageModelValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return PatientPageModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PatientPageModel patientPageModel = (PatientPageModel) target;

        if (patientPageModel.getName() == null || "".equals(patientPageModel.getName())) {
            errors.reject("name", "validator.patient.nameError");
        }

        if (patientPageModel.getCity() == null || "".equals(patientPageModel.getCity())) {
            errors.reject("city", "validator.patient.cityError");
        }

        if (patientPageModel.getAddress() == null || "".equals(patientPageModel.getAddress())) {
            errors.reject("address", "validator.patient.addressError");
        }
    }
}
