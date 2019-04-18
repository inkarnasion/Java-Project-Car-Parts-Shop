package org.softuni.carpartsshop.web.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.config.Constant;
import org.softuni.carpartsshop.domain.models.binding.UserEditBindingModel;
import org.softuni.carpartsshop.domain.models.binding.UserRegisterBindingModel;
import org.softuni.carpartsshop.domain.models.service.UserServiceModel;
import org.softuni.carpartsshop.domain.models.view.UserAllViewModel;
import org.softuni.carpartsshop.domain.models.view.UserProfileViewModel;
import org.softuni.carpartsshop.service.CloudinaryService;
import org.softuni.carpartsshop.service.UserService;
import org.softuni.carpartsshop.web.annotations.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(Constant.REQUEST_MAPPING_USERS)
public class UserController extends BaseController {

	private final UserService userService;
	private final ModelMapper modelMapper;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final CloudinaryService cloudinaryService;

	@Autowired
	public UserController(UserService userService, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder, CloudinaryService cloudinaryService) {
		this.userService = userService;
		this.modelMapper = modelMapper;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.cloudinaryService = cloudinaryService;
	}

	@GetMapping(Constant.REGISTER_PAGE)
	@PreAuthorize("isAnonymous()")
	@PageTitle(Constant.PAGE_TITLE_REGISTER)
	public ModelAndView register() {
		return super.view(Constant.REGISTER_PAGE);
	}

	@PostMapping(Constant.POST_MAPPING_REGISTER)
	@PreAuthorize("isAnonymous()")
	public ModelAndView registerConfirm(@Valid @ModelAttribute(name = "bindingModel") UserRegisterBindingModel model, BindingResult bindingResult) throws IOException {
		if (bindingResult.hasErrors()) {
			return super.redirect(Constant.REGISTER_PAGE);
		}

		if (!model.getPassword().equals(model.getConfirmPassword())) {
			return super.view(Constant.VIEW_REGISTER);
		}
		UserServiceModel userServiceModel = this.modelMapper.map(model, UserServiceModel.class);
		if (!model.getImage().isEmpty()) {
			userServiceModel.setImageUrl(this.cloudinaryService.uploadImage(model.getImage()));
		}
		this.userService.registerUser(userServiceModel);

		return super.redirect(Constant.REDIRECT_LOGIN);
	}

	@GetMapping(Constant.GET_MAPPING_LOGIN)
	@PreAuthorize("isAnonymous()")
	@PageTitle(Constant.PAGE_TITLE)
	public ModelAndView login() {
		return super.view(Constant.VIEW_LOGIN);
	}

	@GetMapping(Constant.ABOUT_ACTION)
	@PageTitle(Constant.PAGE_TITLE_ABOUTH)
	@PreAuthorize("isAnonymous()")
	public ModelAndView About() {
		return super.view(Constant.VIEW_ABOUT);
	}

	@GetMapping(Constant.CONTACT_ACTION)
	@PageTitle(Constant.TITLE_PAGE_CONTACT)
	@PreAuthorize("isAnonymous()")
	public ModelAndView Contact() {
		return super.view(Constant.VIEW_CONTACT);
	}

	@GetMapping(Constant.GET_MAPPING_PROFILE)
	@PageTitle(Constant.PAGE_TITLE_PROFILE)
	@PreAuthorize("isAuthenticated()")
	public ModelAndView profile(Principal principal, ModelAndView modelAndView) {
		modelAndView.addObject(Constant.ADD_OBJECT_MODEL, this.modelMapper.map(this.userService.findUserByUserName(principal.getName()), UserProfileViewModel.class));

		return super.view(Constant.VIEW_PROFILE, modelAndView);
	}

	@GetMapping(Constant.GET_MAPPING_EDIT)
	@PageTitle(Constant.PAGE_TITLE_EDIT_PROFILE)
	@PreAuthorize("isAuthenticated()")
	public ModelAndView editProfile(Principal principal, ModelAndView modelAndView) {
		modelAndView.addObject(Constant.ADD_OBJECT_MODEL, this.modelMapper.map(this.userService.findUserByUserName(principal.getName()), UserEditBindingModel.class));

		return super.view(Constant.VIEW_EDIT_PROFILE, modelAndView);
	}

	@PatchMapping(Constant.PATCH_MAPPING_EDIT)
	@PreAuthorize("isAuthenticated()")
	public ModelAndView editProfileConfirm(@Valid @ModelAttribute(name = Constant.ADD_OBJECT_MODEL) UserEditBindingModel model, BindingResult bindingResult) throws IOException {
		if (bindingResult.hasErrors()) {
			return super.redirect(Constant.VIEW_EDIT_PROFILE);
		}
		if (model.getPassword() != null) {
			if (!model.getPassword().equals(model.getConfirmPassword())) {
				return super.view(Constant.VIEW_EDIT_PROFILE);
			}
		}
		UserServiceModel userServiceModel = this.modelMapper.map(model, UserServiceModel.class);
		if (model.getImage() != null && !model.getImage().isEmpty()) {
			userServiceModel.setImageUrl(this.cloudinaryService.uploadImage(model.getImage()));
		}
		this.userService.editUserProfile(userServiceModel, model.getOldPassword());

		return super.redirect(Constant.REDIRECT_USER_PROFILE);
	}

	@GetMapping(Constant.GET_MAPPING_ALL)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PageTitle(Constant.PAGE_TITLE_ALL_USER)
	public ModelAndView allUsers(ModelAndView modelAndView) {
		List<UserAllViewModel> users = this.userService.findAllUsers().stream().map(u -> {
			UserAllViewModel user = this.modelMapper.map(u, UserAllViewModel.class);
			user.setAuthorities(u.getAuthorities().stream().map(a -> a.getAuthority()).collect(Collectors.toSet()));

			return user;
		}).collect(Collectors.toList());

		modelAndView.addObject(Constant.ADD_OBJECT_USERS, users);

		return super.view(Constant.VIEW_ALL_USERS, modelAndView);
	}

	@PostMapping(Constant.POST_MAPPING_SET_USER_ID)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView setUser(@PathVariable String id) {
		this.userService.setUserRole(id, Constant.SET_ROLE_USER);

		return super.redirect(Constant.REDIRECT_USERS_ALL);
	}

	@PostMapping(Constant.POST_MAPPING_SET_MODERATOR_ID)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView setModerator(@PathVariable String id) {
		this.userService.setUserRole(id, Constant.SET_ROLE_MODERATOR);

		return super.redirect(Constant.REDIRECT_USERS_ALL);
	}

	@PostMapping(Constant.SET_ADMIN_ID)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView setAdmin(@PathVariable String id) {
		this.userService.setUserRole(id, Constant.SET_ROLE_ADMIN);

		return super.redirect(Constant.REDIRECT_USERS_ALL);
	}

	@InitBinder
	private void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
}
