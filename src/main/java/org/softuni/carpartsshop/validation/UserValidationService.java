package org.softuni.carpartsshop.validation;

import org.softuni.carpartsshop.domain.models.service.UserServiceModel;


public interface UserValidationService {
    boolean isValid(UserServiceModel user);
}
