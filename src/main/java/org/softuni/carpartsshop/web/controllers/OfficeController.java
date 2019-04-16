package org.softuni.carpartsshop.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.config.Constant;
import org.softuni.carpartsshop.domain.models.binding.OfficeBindingModel;
import org.softuni.carpartsshop.domain.models.service.OfficeServiceModel;
import org.softuni.carpartsshop.domain.models.view.OfficeAllViewModel;
import org.softuni.carpartsshop.service.CloudinaryService;
import org.softuni.carpartsshop.service.OfficeService;
import org.softuni.carpartsshop.web.annotations.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OfficeController extends BaseController {

	private final OfficeService officeService;
	private final ModelMapper modelMapper;
	private final CloudinaryService cloudinaryService;

	@Autowired
	public OfficeController(OfficeService officeService, ModelMapper modelMapper, CloudinaryService cloudinaryService) {

		this.officeService = officeService;
		this.modelMapper = modelMapper;
		this.cloudinaryService = cloudinaryService;
	}

	@GetMapping(Constant.ADD_OFFICE_ACTION)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PageTitle("Add Offices")
	public ModelAndView addOffice(ModelAndView modelAndView, @ModelAttribute(name = "bindingModel") OfficeBindingModel officeBindingModel) {
		return view(Constant.ADD_OFFICE_PAGE, modelAndView);
	}

	@PostMapping(Constant.ADD_OFFICE_ACTION)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView addOfficeConfirm(@Valid ModelAndView modelAndView, @Valid @ModelAttribute(name = "bindingModel") OfficeBindingModel officeBindingModel, BindingResult bindingResult) throws IOException {
		if (bindingResult.hasErrors()) {
			return super.redirect(Constant.ADD_OFFICE_PAGE);
		}

		OfficeServiceModel officeServiceModel = this.modelMapper.map(officeBindingModel, OfficeServiceModel.class);
		officeServiceModel.setImageUrl(this.cloudinaryService.uploadImage(officeBindingModel.getImage()));

		String id = this.officeService.addOffice(officeServiceModel);
//        if (id == null) {
//            return view(Constant.ADD_OFFICE_PAGE, modelAndView);
//        }

		return redirect(Constant.ALL_OFFICE_PAGE);
	}

	@GetMapping(Constant.ALL_OFFICE_ACTION)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PageTitle("All Offices")
	public ModelAndView allOffices(ModelAndView modelAndView) {
		List<OfficeServiceModel> officeServiceModels = this.officeService.findAllOffices();
		List<OfficeAllViewModel> officeAllViewModels = officeServiceModels.stream().map(o -> this.modelMapper.map(o, OfficeAllViewModel.class)).collect(Collectors.toList());
		modelAndView.addObject("offices", officeAllViewModels);

		return view(Constant.ALL_OFFICE_PAGE, modelAndView);
	}

	@GetMapping(Constant.EDIT_OFFICE_ACTION + "{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PageTitle("Edit Offices")
	public ModelAndView editOffice(ModelAndView modelAndView, @PathVariable String id) {
		OfficeBindingModel officeBindingModel = this.modelMapper.map(this.officeService.findOfficeByID(id), OfficeBindingModel.class);
		modelAndView.addObject("bindingModel", officeBindingModel);

		return view(Constant.EDIT_OFFICE_PAGE, modelAndView);
	}

	@PostMapping(Constant.EDIT_OFFICE_ACTION + "{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView editOfficeConfirm(ModelAndView modelAndView,@Valid @ModelAttribute(name = "bindingModel") OfficeBindingModel officeBindingModel, @PathVariable String id, BindingResult bindingResult) throws IOException {
		if (bindingResult.hasErrors()) {
			return super.redirect(Constant.EDIT_OFFICE_PAGE);
		}
		OfficeServiceModel officeServiceModel = this.modelMapper.map(officeBindingModel, OfficeServiceModel.class);
		if (!officeBindingModel.getImage().isEmpty()) {
			officeServiceModel.setImageUrl(this.cloudinaryService.uploadImage(officeBindingModel.getImage()));
		}
		officeServiceModel.setId(id);
		officeServiceModel = this.officeService.editOffice(officeServiceModel);
		if (officeServiceModel == null) {

			return view(Constant.EDIT_OFFICE_PAGE, modelAndView);
		}

		return redirect(Constant.ALL_OFFICE_PAGE);

	}

	@GetMapping(Constant.DELETE_OFFICE_ACTION + "{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PageTitle("Delete Offices")
	public ModelAndView deleteOffice(ModelAndView modelAndView, @PathVariable String id) {

		OfficeBindingModel officeBindingModel = this.modelMapper.map(this.officeService.findOfficeByID(id), OfficeBindingModel.class);
		modelAndView.addObject("bindingModel", officeBindingModel);

		return view(Constant.DELETE_OFFICE_PAGE, modelAndView);
	}

	@PostMapping(Constant.DELETE_OFFICE_ACTION + "{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView deleteOfficeConfirm(ModelAndView modelAndView, @ModelAttribute(name = "bindingModel") OfficeBindingModel officeBindingModel, @PathVariable String id) {

		OfficeServiceModel officeServiceModel = this.modelMapper.map(officeBindingModel, OfficeServiceModel.class);
		officeServiceModel.setId(id);
		this.officeService.deleteOffice(officeServiceModel);

		return redirect(Constant.ALL_OFFICE_PAGE);

	}

}
