package web.adminlicense.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class contractController {
    @GetMapping("/contract")
    public String getPage(){
        return "contract";
    }
}
