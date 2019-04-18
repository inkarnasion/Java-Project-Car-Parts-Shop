package org.softuni.carpartsshop.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.config.Constant;
import org.softuni.carpartsshop.domain.models.view.OfferViewModel;
import org.softuni.carpartsshop.service.OfferService;

import org.softuni.carpartsshop.web.annotations.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OfferController extends BaseController {

    private final OfferService offerService;
    private final ModelMapper modelMapper;

    @Autowired
    public OfferController(OfferService offerService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(Constant.GET_MAPPING_TOP_OFFERS)
    @PreAuthorize("isAuthenticated()")
    @PageTitle(Constant.PAGE_TITLE_TOP_OFFERS)
    public ModelAndView topOffers(ModelAndView modelAndView) {

        return super.view(Constant.OFFERS_TOP_OFFERS, modelAndView);
    }

    @GetMapping(Constant.GET_MAPPING_OFFERS_CATEGORY)
    @ResponseBody
    public List<OfferViewModel> fetchByCategory(@PathVariable String category) {
        List<OfferViewModel> offerViewModels = this.offerService.findAllOffers()
                .stream()
                .map(o -> this.modelMapper.map(o, OfferViewModel.class))
                .collect(Collectors.toList());

        return offerViewModels;
    }
}
