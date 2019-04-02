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
                .antMatchers("/js/**", "/css/**","/static/**","/img/**","/templates/**","/about","/contact").permitAll()
                .antMatchers(GlobalConstant.INDEX_ACTION, GlobalConstant.REGISTER_FORM_ACTION, GlobalConstant.LOGIN_FORM_ACTION,"/users/about").anonymous()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(GlobalConstant.LOGIN_FORM_ACTION)
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl(GlobalConstant.HOME_ACTION,true)
                .and()
                .logout()
                .logoutSuccessUrl(GlobalConstant.INDEX_ACTION);
    }
}
