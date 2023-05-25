package com.csci5308.codeLabeller.Components;

import com.csci5308.codeLabeller.Enums.JwtEnum;
<<<<<<< HEAD
=======
import com.csci5308.codeLabeller.Enums.JwtNumbers;
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
import com.csci5308.codeLabeller.Service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
<<<<<<< HEAD
=======
import org.springframework.security.core.GrantedAuthority;
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
<<<<<<< HEAD

=======
import java.util.Collection;

/**
 * jet filter chain to handle jwt token in header.
 */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
@Component
public class JwtFilterChain extends OncePerRequestFilter {

    @Autowired
    JwtService jwtService;

    @Autowired
    UserDetailsManager userDetailsManager;

<<<<<<< HEAD
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(JwtEnum.AUTHORIZATION.toString());
        String username,jwtToken;
=======
    /**
     * internal filter to extract jwt token, extract all information from it
     * and setting the context holder.
     * @param request: http request
     * @param response: http response
     * @param filterChain: filter chain object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(JwtEnum.AUTHORIZATION.toString());
        String username;
        String jwtToken;
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
        UserDetails userDetails = null;
        WebAuthenticationDetails webAuthenticationDetails = null;

        if(authHeader!=null && authHeader.startsWith(JwtEnum.Bearer.toString()+" ")){
<<<<<<< HEAD
            jwtToken = authHeader.substring(7);
=======
            jwtToken = authHeader.substring(JwtNumbers.BearerMark.getValue());
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
            username = jwtService.getUsername(jwtToken);
            userDetails = userDetailsManager.loadUserByUsername(username);
            if(username!=null && SecurityContextHolder.getContext().getAuthentication() == null){
                if(jwtService.isValid(jwtToken, userDetails)){
<<<<<<< HEAD
                    UsernamePasswordAuthenticationToken unpa = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
=======
                    UsernamePasswordAuthenticationToken unpa;
                    String usrDetName = userDetails.getUsername();
                    String usrDetPass = userDetails.getPassword();
                    Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
                    unpa = new UsernamePasswordAuthenticationToken(usrDetName, usrDetPass, authorities);
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
                    webAuthenticationDetails =  new WebAuthenticationDetailsSource().buildDetails(request);
                    unpa.setDetails(webAuthenticationDetails);
                    SecurityContextHolder.getContext().setAuthentication(unpa);
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
