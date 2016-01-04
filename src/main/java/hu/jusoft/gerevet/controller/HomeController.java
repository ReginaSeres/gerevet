package hu.jusoft.gerevet.controller;

import hu.jusoft.gerevet.repository.model.Examination;
import hu.jusoft.gerevet.service.ListingExaminationService;
import hu.jusoft.gerevet.view.model.PatientPageModel;
import hu.jusoft.gerevet.view.modelbuilder.HomeModelBuilder;
import hu.jusoft.gerevet.service.ListingPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import static hu.jusoft.gerevet.controller.ControllerConstants.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by Regina Seres on 12/9/2015.
 */
@Controller
public class HomeController {
    private static final int COUNT_EXAMINATIONS_ON_ONE_PAGE = 9;

    @Autowired
    private HomeModelBuilder homeModelBuilder;

    @Autowired
    private ListingExaminationService listingExaminationService;

    private final static Logger LOG = LoggerFactory
            .getLogger(HomeController.class);

    @RequestMapping(value = HOME_URL)
    public ModelAndView index(@RequestParam(value = "actPage", required = false, defaultValue = "1") int actPage, Locale locale) {
        actPage--;
        Page<Examination> listOfExaminationsPage = listingExaminationService.getNExamiationsInActualPage(actPage, COUNT_EXAMINATIONS_ON_ONE_PAGE);

        ModelAndView mav = new ModelAndView("index");
        mav.addAllObjects(homeModelBuilder.buildHomeModelMap(listOfExaminationsPage));

        return mav;
    }

    @RequestMapping(value = SEARCH_ONE_PARAMETRIZED_URL)
    public ModelAndView indexSearch(@PathVariable(SEARCH_INDEX_VARIABLE) int actPage, Locale locale) {
        return index(actPage, locale);
    }

    @RequestMapping(value = SEARCH_TWO_PARAMETRIZED_URL)
    public ModelAndView searchNameJSON(@PathVariable(SEARCH_QUERY_VARIABLE) String query, @PathVariable(SEARCH_INDEX_VARIABLE) int actPage, Model model, Locale locale) {
        return index(actPage, locale);
    }

    @RequestMapping(value = SEARCH_NAME_URL)
    public void searchForName(
            @RequestParam(value = "queryName", required = true) String queryName, HttpServletResponse response) {
        try {
            response.sendRedirect(SEARCH_URL + "/" + queryName + "/1");
        } catch (IOException e) {
            LOG.error("Unexpected exception happened. Faild to redirect the webpage");
        }
    }

    @RequestMapping(value = SEARCH_NAME_JSON_URL)
    public @ResponseBody List<PatientPageModel> getPatientQueryName(
            @RequestParam(value = SEARCH_QUERY_VARIABLE, required = true) String query) {
        List<PatientPageModel> listOfPatient = new ArrayList<PatientPageModel>();

        return listOfPatient;
    }
}
