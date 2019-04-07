package org.softuni.carpartsshop.web.controllers;


import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.config.Constant;
import org.softuni.carpartsshop.domain.models.view.OfficeAllViewModel;
import org.softuni.carpartsshop.service.CloudinaryService;
import org.softuni.carpartsshop.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController extends BaseController {

    private final OfficeService officeService;
    private final CloudinaryService cloudinaryService;
    private final ModelMapper modelMapper;


    @Autowired
    public HomeController(OfficeService officeService, CloudinaryService cloudinaryService, ModelMapper modelMapper) {
        this.officeService = officeService;

        this.cloudinaryService = cloudinaryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(Constant.INDEX_ACTION)
    @PreAuthorize("isAnonymous()")
    public ModelAndView index() {
        return super.view("index");
    }

    @GetMapping(Constant.HOME_ACTION)
    @PreAuthorize("isAuthenticated()")
    public ModelAndView home() {
        return super.view("home");
    }

    @GetMapping("/about")
    public ModelAndView About() {
        return super.view("about");
    }

    @GetMapping("/contact")
    public ModelAndView Contact(ModelAndView modelAndView) {
        List<OfficeAllViewModel> officeAllViewModelList = this.officeService.findAllOffices().stream().map(o -> this.modelMapper.map(o, OfficeAllViewModel.class)).collect(Collectors.toList());
        modelAndView.addObject("offices", officeAllViewModelList);
       //return super.view("contact");
        return view("contact", modelAndView);
    }
}
