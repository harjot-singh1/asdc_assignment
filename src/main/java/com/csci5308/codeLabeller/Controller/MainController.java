package com.csci5308.codeLabeller.Controller;

import com.csci5308.codeLabeller.Models.UserSignUpDetails;
import com.csci5308.codeLabeller.Service.UserSignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableMethodSecurity
public class MainController {

    @Autowired
    UserSignUpService userSignUpService;

    @GetMapping("/annotator")
    @PreAuthorize("hasAuthority('ANNOTATOR')")
    public String getLabeller(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName()+" is Annotator";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String getAdmin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName()+" is admin";
    }
    @PostMapping("/signup")
    public void signUp(@RequestBody UserSignUpDetails user){
        userSignUpService.registerUser(user);
    }
}
