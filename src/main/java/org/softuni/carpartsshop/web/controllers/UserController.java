package org.softuni.carpartsshop.web.controllers;


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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
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

    @GetMapping("/register")
    @PreAuthorize("isAnonymous()")
    @PageTitle("Register")
    public ModelAndView register() {
        return super.view(Constant.REGISTER_PAGE);
    }

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ModelAndView registerConfirm(@ModelAttribute UserRegisterBindingModel model) throws IOException {

        if (!model.getPassword().equals(model.getConfirmPassword())) {
            return super.view("register");
        }
        UserServiceModel userServiceModel = this.modelMapper.map(model, UserServiceModel.class);
        if (!model.getImage().isEmpty()) {
            userServiceModel.setImageUrl(this.cloudinaryService.uploadImage(model.getImage()));
        }
        this.userService.registerUser(this.modelMapper.map(model, UserServiceModel.class));

        return super.redirect("/login");
    }

    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    @PageTitle("Login")
    public ModelAndView login() {
        return super.view("login");
    }

    @GetMapping("/about")
    @PageTitle("About")
    @PreAuthorize("isAnonymous()")
    public ModelAndView About(){
        return super.view("about");
    }


    @GetMapping("/contact")
    @PageTitle("Contact")
    @PreAuthorize("isAnonymous()")
    public ModelAndView Contact(){
        return super.view("contact");
    }


    @GetMapping("/profile")
    @PageTitle("Profile")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView profile(Principal principal, ModelAndView modelAndView) {
        modelAndView
                .addObject("model", this.modelMapper.map(this.userService.findUserByUserName(principal.getName()), UserProfileViewModel.class));

        return super.view("profile", modelAndView);
    }

    @GetMapping("/edit")
    @PageTitle("Edit Profile")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView editProfile(Principal principal, ModelAndView modelAndView) {
        modelAndView
                .addObject("model", this.modelMapper.map(this.userService.findUserByUserName(principal.getName()), UserProfileViewModel.class));

        return super.view("edit-profile", modelAndView);
    }

    @PatchMapping("/edit")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView editProfileConfirm(@ModelAttribute UserEditBindingModel model) throws IOException {
        if (!model.getPassword().equals(model.getConfirmPassword())) {
            return super.view("edit-profile");
        }
        UserServiceModel userServiceModel = this.modelMapper.map(model, UserServiceModel.class);
        if (!model.getImage().isEmpty()) {
            userServiceModel.setImageUrl(this.cloudinaryService.uploadImage(model.getImage()));
        }
        this.userService.editUserProfile(this.modelMapper.map(model, UserServiceModel.class), model.getOldPassword());

        return super.redirect("/users/profile");
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PageTitle("All Users")
    public ModelAndView allUsers(ModelAndView modelAndView) {
        List<UserAllViewModel> users = this.userService.findAllUsers()
                .stream()
                .map(u -> {
                    UserAllViewModel user = this.modelMapper.map(u, UserAllViewModel.class);
                    user.setAuthorities(u.getAuthorities().stream().map(a -> a.getAuthority()).collect(Collectors.toSet()));

                    return user;
                })
                .collect(Collectors.toList());

        modelAndView.addObject("users", users);

        return super.view("all-users", modelAndView);
    }

    @PostMapping("/set-user/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView setUser(@PathVariable String id) {
        this.userService.setUserRole(id, "user");

        return super.redirect("/users/all");
    }

    @PostMapping("/set-moderator/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView setModerator(@PathVariable String id) {
        this.userService.setUserRole(id, "moderator");

        return super.redirect("/users/all");
    }

    @PostMapping("/set-admin/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView setAdmin(@PathVariable String id) {
        this.userService.setUserRole(id, "admin");

        return super.redirect("/users/all");
    }
    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}


