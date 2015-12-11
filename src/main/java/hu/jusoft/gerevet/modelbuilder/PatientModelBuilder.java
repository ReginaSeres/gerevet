package hu.jusoft.gerevet.modelbuilder;

import hu.jusoft.gerevet.domain.model.Examination;
import hu.jusoft.gerevet.domain.model.Patient;
import hu.jusoft.gerevet.service.ListingExaminationService;
import hu.jusoft.gerevet.service.PatientManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Component
public class PatientModelBuilder {

    @Autowired
    private PatientManagerService patientManagerService;

    @Autowired
    private ListingExaminationService listingExaminationService;

    public String buildPatientModelMap(String id, Model model) {
        setPatientAndEditPatientModelMap(id, model);
        return "patient";
    }

    public String buildEditPatientModelMap(String id, Model model) {
        setPatientAndEditPatientModelMap(id, model);
        return "editPatient";
    }

    private void setPatientAndEditPatientModelMap(String id, Model model) {
        Patient actualPatient = patientManagerService.getActualPatientFromId(id);
        List<Examination> listOfExaminationsForActualPatient = listingExaminationService.getListOfExaminationsForActualPatientId(id);

        model.addAttribute("patient", actualPatient);
        model.addAttribute("examinations", listOfExaminationsForActualPatient);
    }

}
