package com.csci5308.codeLabeller.Security;

import com.csci5308.codeLabeller.Components.JwtFilterChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

<<<<<<< HEAD
=======
/**
 * configuration helps with creating helper beans for jwt token.
 */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
@Configuration
public class SecurityConfiguration {

    @Autowired
    JwtFilterChain jwtFilterChain;

<<<<<<< HEAD
    //first run script from user.ddl

=======

    /**
     * creates bean for authmanager provided by spring.
     * @param authConfig: auth configuration object.
     * @return: auth manager object.
     * @throws Exception
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

<<<<<<< HEAD
=======
    /**
     * authentication filter for spring security
     * @param httpSecurity: security object
     * @return: filter chain for spring security.
     * @throws Exception
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    @Bean
    public SecurityFilterChain authenticationFilter(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/signup")
                .permitAll()
                .requestMatchers("/login")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtFilterChain, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

}
