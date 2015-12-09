package hu.jusoft.gerevet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Gidu on 12/9/2015.
 */
@Controller
public class HomeController {
    @RequestMapping(value = {"", "/"})
    public String index() {
        return "index";
    }
}
