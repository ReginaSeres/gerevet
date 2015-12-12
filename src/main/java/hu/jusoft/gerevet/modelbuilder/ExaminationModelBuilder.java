package hu.jusoft.gerevet.modelbuilder;

import hu.jusoft.gerevet.domain.model.Examination;
import hu.jusoft.gerevet.service.ExaminationManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Component
public class ExaminationModelBuilder {

    @Autowired
    private ExaminationManagerService examinationManagerService;

    public String buildHomeModelMap(String examinationId, Model model) {
        Examination actualExamination = examinationManagerService.getActualExaminationFromId(examinationId);

        model.addAttribute("examination", actualExamination);
        model.addAttribute("editJS", "editJS");

        return "examination";
    }
}
