package org.softuni.carpartsshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(Constant.JS_PATH, Constant.CSS_PATH,Constant.STATIC_PATH,Constant.IMG_PATH,Constant.TEMPLATES_PATH,Constant.VIDEO_PATH,Constant.ABOUT_PATH,Constant.CONTACT_PATH).permitAll()
                .antMatchers(Constant.INDEX_ACTION, Constant.REGISTER_FORM_ACTION, Constant.LOGIN_FORM_ACTION,Constant.USERS_ABOUT_PATH).anonymous()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(Constant.LOGIN_FORM_ACTION)
                .usernameParameter(Constant.USERNAME_PATH)
                .passwordParameter(Constant.PASSWORD_PATH)
                .defaultSuccessUrl(Constant.HOME_ACTION,true)
                .and()
                .logout()
                .logoutSuccessUrl(Constant.INDEX_ACTION)
                .and()
                .exceptionHandling()
                .accessDeniedPage(Constant.INDEX_ACTION);

    }
}
