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
                .antMatchers("/js/**", "/css/**","/static/**","/img/**","/templates/**","/video/**","/about","/contact").permitAll()
                .antMatchers(Constant.INDEX_ACTION, Constant.REGISTER_FORM_ACTION, Constant.LOGIN_FORM_ACTION,"/users/about").anonymous()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(Constant.LOGIN_FORM_ACTION)
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl(Constant.HOME_ACTION,true)
                .and()
                .logout()
                .logoutSuccessUrl(Constant.INDEX_ACTION)
                .and()
                .exceptionHandling()
                .accessDeniedPage("/");

    }
}
