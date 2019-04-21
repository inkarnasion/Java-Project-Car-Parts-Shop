package org.softuni.carpartsshop.domain.models.binding;

import org.hibernate.validator.constraints.Length;
import org.softuni.carpartsshop.config.Constant;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {
	private String username;
	private String password;

	public UserLoginBindingModel() {
	}

	@NotNull(message = Constant.NAME_CANNOT_BE_NULL)
	@NotEmpty
	@Length(min = 2, message = Constant.USERNAME_MUST_BE_ATLEAST_2_CHARACTER_LONG)
	@Length(max = 20, message = Constant.USERNAME_MUST_BE_MAXIMUM_20_CHARACTER_LONG)

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotNull(message = Constant.NAME_CANNOT_BE_NULL)
	@NotEmpty
	@Length(min = 6, message = Constant.PASSWORD_MUST_BE_ATLEAST_6_CHARACTER_LONG)
	@Length(max = 20, message = Constant.PASSWORD_MUST_BE_MAXIMUM_20_CHARACTER_LONG)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
