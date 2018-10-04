package web.adminlicense.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger("LoginController.class");

    @GetMapping("/login")
    public String getLoginPage(Authentication authentication, ModelMap model, HttpServletRequest request){
        logger.info("!!!!!!!!!!!!!!!!TEST");

        if(authentication != null && authentication.isAuthenticated()){
            return "redirect:index";
        }
        if(request.getParameterMap().containsKey("error")){
            model.addAttribute("error", "Логин или пароль введены не правильно!");
        }
        return "login";
    }
}
