package hu.jusoft.gerevet.controller;

import hu.jusoft.gerevet.domain.model.Patient;
import hu.jusoft.gerevet.service.ListingPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Gidu on 12/9/2015.
 */
@Controller
public class HomeController {
    @Autowired
    private ListingPatientService listingPatientService;

    @RequestMapping(value = {"", "/"})
    public String index(@RequestParam(value = "actPage", required = false, defaultValue = "1") int actPage, Model model) {
        return setModel("", actPage, model);
    }

    @RequestMapping(value = {"/search/{actPage}"})
    public String indexSearch(@PathVariable("actPage") int actPage, Model model) {
        return setModel("", actPage, model);
    }

    @RequestMapping(value = {"/search/{query}/{actPage}"})
    public String searchNameJSON(@PathVariable("query") String query, @PathVariable("actPage") int actPage, Model model) {
        return setModel(query, actPage, model);
    }

    @RequestMapping("/searchName")
    public void searchForName(
            @RequestParam(value = "queryName", required = true) String queryName, HttpServletResponse response) {
        try {
            response.sendRedirect("/search/" + queryName + "/1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/searchNameJSON")
    public @ResponseBody List<Patient> getPatientQueryName(
            @RequestParam(value = "query", required = true) String query) {
    //    List<Patient> listOfPatient = listingPatientService.getListOfPatientFromQuery(query);
        List<Patient> listOfPatient = listingPatientService.getListOfPatient();

        return listOfPatient;
    }

    public String setModel(String queryName, int actPage, Model model) {

        List<Patient> listOfPatient = listingPatientService.getTenPatientFromActualPage(actPage);
        int pagesCount = listingPatientService.getPagesCount();

        model.addAttribute("actPage", actPage);
        model.addAttribute("listOfPatient", listOfPatient);
        model.addAttribute("pageCount", pagesCount);
        model.addAttribute("url", "/search/*");
        model.addAttribute("queryName", queryName);

        return "index";
    }
}
