package hu.jusoft.gerevet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static hu.jusoft.gerevet.controller.ControllerConstants.*;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Controller
public class LoginController {

    @RequestMapping(value = LOGIN_URL)
    public String showLoginForm(HttpServletRequest request) {
        return LOGIN;
    }

}
