package hu.jusoft.gerevet.modelbuilder;

import hu.jusoft.gerevet.domain.model.Examination;
import hu.jusoft.gerevet.service.ListingExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Locale;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Component
public class HomeModelBuilder {

    @Autowired
    private MessageSource msg;

    @Autowired
    private ListingExaminationService listingExaminationService;

    public String buildHomeModelMap(int actPage, Model model, Locale locale) {
        return buildHomeModelMap("", actPage, model, locale);
    }

    public String buildHomeModelMap(String queryName, int actPage, Model model, Locale locale) {

        List<Examination> listOfExaminations = listingExaminationService.getTenExaminationFromActualPage(actPage);
        int pagesCount = listingExaminationService.getPagesCount();

        System.out.print(msg.getMessage("index.placeholder.search", null, locale));

        model.addAttribute("actPage", actPage);
        model.addAttribute("listOfExaminations", listOfExaminations);
        model.addAttribute("pageCount", pagesCount);
        model.addAttribute("url", "/search/*");
        model.addAttribute("queryName", queryName);

        return "index";
    }
}
