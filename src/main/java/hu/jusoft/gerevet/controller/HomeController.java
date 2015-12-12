package hu.jusoft.gerevet.controller;

import hu.jusoft.gerevet.modelbuilder.HomeModelBuilder;
import hu.jusoft.gerevet.domain.model.Patient;
import hu.jusoft.gerevet.service.ListingPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by Regina Seres on 12/9/2015.
 */
@Controller
public class HomeController {
    @Autowired
    private ListingPatientService listingPatientService;

    @Autowired
    private HomeModelBuilder homeModelBuilder;

    private final static Logger LOG = LoggerFactory
            .getLogger(HomeController.class);

    @RequestMapping("")
    public String index(@RequestParam(value = "actPage", required = false, defaultValue = "1") int actPage, Model model, Locale locale) {
        return homeModelBuilder.buildHomeModelMap(actPage, model, locale);
    }

    @RequestMapping("/search/{actPage}")
    public String indexSearch(@PathVariable("actPage") int actPage, Model model, Locale locale) {
        return homeModelBuilder.buildHomeModelMap(actPage, model, locale);
    }

    @RequestMapping("/search/{query}/{actPage}")
    public String searchNameJSON(@PathVariable("query") String query, @PathVariable("actPage") int actPage, Model model, Locale locale) {
        return homeModelBuilder.buildHomeModelMap(query, actPage, model, locale);
    }

    @RequestMapping("/searchName")
    public void searchForName(
            @RequestParam(value = "queryName", required = true) String queryName, HttpServletResponse response) {
        try {
            response.sendRedirect("/search/" + queryName + "/1");
        } catch (IOException e) {
            LOG.error("Unexpected exception happened. Faild to redirect the webpage");
        }
    }

    @RequestMapping("/searchNameJSON")
    public @ResponseBody List<Patient> getPatientQueryName(
            @RequestParam(value = "query", required = true) String query) {
    //    List<Patient> listOfPatient = listingPatientService.getListOfPatientFromQuery(query);
        List<Patient> listOfPatient = listingPatientService.getListOfPatient();

        return listOfPatient;
    }
}
