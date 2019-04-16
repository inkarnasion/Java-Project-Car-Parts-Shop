package org.softuni.carpartsshop.domain.models.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {
	private String username;
	private String password;

	public UserLoginBindingModel() {
	}

	@NotNull(message = "Name cannot be null")
	@NotEmpty
	@Length(min = 2, message = "UserName must be at least 2 characters long.")
	@Length(max = 20, message = "UserName must be maximum 20 characters long.")

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotNull(message = "Name cannot be null")
	@NotEmpty
	@Length(min = 6, message = "Password must be at least 2 characters long.")
	@Length(max = 20, message = "Password must be maximum 20 characters long.")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
