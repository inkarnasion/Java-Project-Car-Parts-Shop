package org.softuni.carpartsshop.domain.models.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {
	private String username;
	private String password;

	public UserLoginBindingModel() {
	}

	@NotNull(message = "can not be empty!")
	@Size(min = 1, message = "can not be empty")

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotNull(message = "can not be empty!")
	@Size(min = 1, message = "can not be empty")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
