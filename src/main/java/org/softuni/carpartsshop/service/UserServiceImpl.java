package org.softuni.carpartsshop.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.config.Constant;
import org.softuni.carpartsshop.domain.entites.User;
import org.softuni.carpartsshop.domain.models.service.UserServiceModel;
import org.softuni.carpartsshop.repository.UserRepository;
import org.softuni.carpartsshop.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final RoleService roleService;
	private final ModelMapper modelMapper;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ValidationUtil validationUtil;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleService roleService, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder,
	    ValidationUtil validationUtil) {
		this.userRepository = userRepository;
		this.roleService = roleService;
		this.modelMapper = modelMapper;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.validationUtil = validationUtil;
	}


	@Override
	public UserServiceModel registerUser(UserServiceModel userServiceModel) {
		if (!this.validationUtil.isValid(userServiceModel)) {
			throw new IllegalArgumentException(Constant.TRYING_TO_ADD_INVALID_DATA);
		}
		this.roleService.seedRolesInDb();
		if (this.userRepository.count() == 0) {
			userServiceModel.setAuthorities(this.roleService.findAllRoles());
		} else {
			userServiceModel.setAuthorities(new LinkedHashSet<>());

			userServiceModel.getAuthorities().add(this.roleService.findByAuthority("ROLE_USER"));
		}

		User user = this.modelMapper.map(userServiceModel, User.class);
		user.setPassword(this.bCryptPasswordEncoder.encode(userServiceModel.getPassword()));

		if (this.userRepository.findByUsername(user.getUsername()).orElse(null) != null) {
			throw new IllegalArgumentException(Constant.EXIST_USER_IN_DATABASE);
		}

		user = this.userRepository.saveAndFlush(user);

		return this.modelMapper.map(user, UserServiceModel.class);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws IllegalArgumentException {


		return this.userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException(Constant.USERNAME_NOT_FOUND));
	}

	@Override
	public UserServiceModel findUserByUserName(String username) {
		return this.userRepository.findByUsername(username).map(u -> this.modelMapper.map(u, UserServiceModel.class)).orElseThrow(() -> new IllegalArgumentException(
		    Constant.USERNAME_NOT_FOUND));
	}

	@Override
	public UserServiceModel editUserProfile(UserServiceModel userServiceModel, String oldPassword) {
		if (!this.validationUtil.isValid(userServiceModel)) {
			throw new IllegalArgumentException(Constant.TRYING_TO_ADD_INVALID_DATA);
		}

		User user = this.userRepository.findByUsername(userServiceModel.getUsername()).orElseThrow(() -> new IllegalArgumentException(Constant.USERNAME_NOT_FOUND));

		if (userServiceModel.getPassword() != null) {
			if (!this.bCryptPasswordEncoder.matches(oldPassword, user.getPassword())) {
				throw new IllegalArgumentException(Constant.INCORECT_PASSWORD);
			}

			user.setPassword(!"".equals(userServiceModel.getPassword()) ? this.bCryptPasswordEncoder.encode(userServiceModel.getPassword()) : user.getPassword());
		} else {

		}

		user.setEmail(userServiceModel.getEmail());
		user.setImageUrl(userServiceModel.getImageUrl());

		return this.modelMapper.map(this.userRepository.saveAndFlush(user), UserServiceModel.class);
	}

	@Override
	public List<UserServiceModel> findAllUsers() {
		return this.userRepository.findAll().stream().map(u -> this.modelMapper.map(u, UserServiceModel.class)).collect(Collectors.toList());
	}

	@Override
	public void setUserRole(String id, String role) {
		User user = this.userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(Constant.INCORECT_ID));

		UserServiceModel userServiceModel = this.modelMapper.map(user, UserServiceModel.class);
		userServiceModel.getAuthorities().clear();

		switch (role) {
		case "user":
			userServiceModel.getAuthorities().add(this.roleService.findByAuthority("ROLE_USER"));
			break;
		case "moderator":
			userServiceModel.getAuthorities().add(this.roleService.findByAuthority("ROLE_USER"));
			userServiceModel.getAuthorities().add(this.roleService.findByAuthority("ROLE_MODERATOR"));
			break;
		case "admin":
			userServiceModel.getAuthorities().add(this.roleService.findByAuthority("ROLE_USER"));
			userServiceModel.getAuthorities().add(this.roleService.findByAuthority("ROLE_MODERATOR"));
			userServiceModel.getAuthorities().add(this.roleService.findByAuthority("ROLE_ADMIN"));
			break;
			default:
				throw new IllegalArgumentException(Constant.INVALID_ROLES);

		}

		this.userRepository.saveAndFlush(this.modelMapper.map(userServiceModel, User.class));
	}
}
