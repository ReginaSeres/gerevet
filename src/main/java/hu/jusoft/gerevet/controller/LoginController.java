package hu.jusoft.gerevet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm(HttpServletRequest request) {
        return "login";
    }
}
