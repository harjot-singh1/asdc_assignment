package com.csci5308.codeLabeller.Repsoitory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
=======
/**
 * user sign up repository
 */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
@Repository
public class UserSignUpRepository {

    @Autowired
    UserDetailsManager jdbcUserDetailsManager;

<<<<<<< HEAD
=======
    /**
     * calling jdbc manager to register the user.
     * @param user: user details object.
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    public void registerTheUser(UserDetails user){
        jdbcUserDetailsManager.createUser(user);
    }

<<<<<<< HEAD
=======
    /**
     * find username based on username
     * @param username: username
     * @return: user details object.
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    public UserDetails findByUsername(String username){
        return jdbcUserDetailsManager.loadUserByUsername(username);
    }

}
