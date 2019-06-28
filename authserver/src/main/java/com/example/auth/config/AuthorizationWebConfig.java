package com.example.auth.config;

import com.example.auth.filter.SimpleCORSFilter;
import com.example.auth.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

/**
 * web安全配置
 * Created by WenChen on 2019/6/21.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
public class AuthorizationWebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SimpleCORSFilter simpleCORSFilter;

    @Autowired
    private MyUserDetailService userDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder());
        auth.parentAuthenticationManager(authenticationManagerBean());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**", "/css/**", "/images/**","/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .requestMatchers()   //　requestMatchers 配置　数组
                .antMatchers("/oauth/**","/login","/home")
                .and()
                .authorizeRequests()         //authorizeRequests　配置权限　顺序为先配置需要放行的url 在配置需要权限的url，最后再配置.anyRequest().authenticated()
                .antMatchers("/oauth/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll();
        http.addFilterBefore(simpleCORSFilter, SecurityContextPersistenceFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
