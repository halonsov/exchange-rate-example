package com.halonsov.examples.exchangerate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("userapi")
                .password("$2a$12$43O8XBGxsGg7SQFkyZbF4egMTJh5fSM4HEflXkMVgK2re/RFOfWPG")
                .roles("USER")
            .and()
                .withUser("admin")
                .password("$2a$12$JArxW9H/WgKEL6dEfb9GcOOOjrjnfecd3WiQJwMZzXNv0yq07v3mS")
                .roles("ADMIN")
            ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/swagger-ui.html").permitAll()
            .antMatchers("/v3/api-docs").permitAll()
            .antMatchers("/v3/api-docs/*").permitAll()
            .antMatchers("/swagger-ui/*").permitAll()
            .antMatchers("/v1/exchange").hasAnyRole("USER", "ADMIN")
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }
}
