package hu.jusoft.gerevet.controller;

import hu.jusoft.gerevet.repository.model.Examination;
import hu.jusoft.gerevet.service.ExaminationManagerService;
import hu.jusoft.gerevet.view.modelbuilder.ExaminationModelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Controller
public class ExaminationController {

    @Autowired
    private ExaminationModelBuilder examinationModelBuilder;

    @Autowired
    private ExaminationManagerService examinationManagerService;

    @RequestMapping("/examination/{id}")
    public ModelAndView examination(@PathVariable("id") String id) {
        Examination examination = examinationManagerService.findOne(id);

        ModelAndView mav = new ModelAndView("examination");
        mav.addAllObjects(examinationModelBuilder.buildExaminationMap(examination));

        return mav;
    }
}
