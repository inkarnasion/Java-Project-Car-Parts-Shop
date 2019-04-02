package org.softuni.carpartsshop.web.controllers;


import org.softuni.carpartsshop.config.GlobalConstant;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {


    @GetMapping(GlobalConstant.INDEX_ACTION)
    @PreAuthorize("isAnonymous()")
    public ModelAndView index(){
    return super.view("index");
    }

    @GetMapping(GlobalConstant.HOME_ACTION)
    @PreAuthorize("isAuthenticated()")
    public ModelAndView home(){
return super.view("home");
    }

    @GetMapping("/about")
    public ModelAndView About(){
        return super.view("about");
    }

    @GetMapping("/contact")
    public ModelAndView Contact(){
        return super.view("contact");
    }
}
