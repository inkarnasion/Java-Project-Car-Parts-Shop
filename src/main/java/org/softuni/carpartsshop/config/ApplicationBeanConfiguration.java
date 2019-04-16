package org.softuni.carpartsshop.config;

import org.modelmapper.ModelMapper;

import org.softuni.carpartsshop.utils.ValidationUtil;
import org.softuni.carpartsshop.utils.ValidationUtilImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ApplicationBeanConfiguration {




    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Bean
    public Validator validator()
    {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }
    @Bean
    public ValidationUtil validationUtil() {
        return new ValidationUtilImpl();
    }
}
