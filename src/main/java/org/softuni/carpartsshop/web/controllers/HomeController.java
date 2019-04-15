package org.softuni.carpartsshop.web.controllers;


import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.config.Constant;
import org.softuni.carpartsshop.domain.models.view.OfficeAllViewModel;
import org.softuni.carpartsshop.service.CloudinaryService;
import org.softuni.carpartsshop.service.OfficeService;
import org.softuni.carpartsshop.web.annotations.PageTitle;
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
    @PageTitle(Constant.PAGE_TITLE_INDEX)
    public ModelAndView index() {
        return super.view(Constant.PAGE_VIEW_NAME_INDEX);
    }

    @GetMapping(Constant.HOME_ACTION)
    @PreAuthorize("isAuthenticated()")
    @PageTitle(Constant.PAGE_TITLE_HOME)
    public ModelAndView home() {
        return super.view(Constant.PAGE_VIEW_NAME_HOME);
    }

    @GetMapping(Constant.ABOUT_ACTION)
    @PageTitle(Constant.PAGE_TITLE_ABOUT)
    public ModelAndView About() {
        return super.view(Constant.PAGE_VIEW_NAME_ABOUT);
    }

    @GetMapping(Constant.CONTACT_ACTION)
    @PageTitle(Constant.PAGE_TITLE_CONTACT_US)
    public ModelAndView Contact(ModelAndView modelAndView) {
        List<OfficeAllViewModel> officeAllViewModelList = this.officeService.findAllOffices().stream().map(o -> this.modelMapper.map(o, OfficeAllViewModel.class)).collect(Collectors.toList());
        modelAndView.addObject(Constant.ADD_OBJECT_OFFICES, officeAllViewModelList);

        return view(Constant.REDIRECT_VIEW_CONTACT, modelAndView);
    }
}
