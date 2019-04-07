package org.softuni.carpartsshop.validation.implementations;


import org.softuni.carpartsshop.domain.models.service.UserServiceModel;
import org.softuni.carpartsshop.validation.UserValidationService;
import org.springframework.stereotype.Component;

@Component
public class UserValidationServiceImpl implements UserValidationService {
    @Override
    public boolean isValid(UserServiceModel user) {
        return user != null;
    }
}
