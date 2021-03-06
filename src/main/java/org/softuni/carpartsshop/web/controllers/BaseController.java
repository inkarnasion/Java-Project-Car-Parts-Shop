package org.softuni.carpartsshop.web.controllers;

import org.softuni.carpartsshop.config.Constant;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {

    protected ModelAndView view(String view,ModelAndView modelAndView){
        modelAndView.setViewName(view);

        return modelAndView;
    }

    protected ModelAndView view(String view){
        return this.view(view, new ModelAndView());
    }

    protected ModelAndView redirect(String url){
        return this.view(Constant.FORM_REDIRECT + url);
    }
}
