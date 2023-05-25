package com.csci5308.codeLabeller.Controller;

import com.csci5308.codeLabeller.Models.DTO.AuthResponse;
import com.csci5308.codeLabeller.Models.DTO.UserLoginDetails;
import com.csci5308.codeLabeller.Service.UserSignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@CrossOrigin
@EnableMethodSecurity
@RestController
public class LoginController {

    @Autowired
    UserSignUpService userSignUpService;
<<<<<<< HEAD
=======
    /**
     * This url returns list of pending surveys
     * It expects annotator's username as payload for call
     * @param user This is object of UserLoginDetails class
     * @return AuthResponse this returns jwtToken
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody UserLoginDetails user){
        return ResponseEntity.ok(userSignUpService.authenticate(user));
    }
}
