package hu.jusoft.gerevet.controller;

import hu.jusoft.gerevet.modelbuilder.ExaminationModelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Controller
public class ExaminationController {

    @Autowired
    private ExaminationModelBuilder examinationModelBuilder;

    @RequestMapping("/examination/{id}")
    public String examination(@PathVariable("id") String id, Model model) {
        return examinationModelBuilder.buildHomeModelMap(id, model);
    }
}
