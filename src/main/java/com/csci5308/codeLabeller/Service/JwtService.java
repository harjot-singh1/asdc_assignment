package com.csci5308.codeLabeller.Service;

import com.csci5308.codeLabeller.Enums.JwtEnum;
<<<<<<< HEAD
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
=======
import com.csci5308.codeLabeller.Enums.JwtNumbers;
import io.jsonwebtoken.*;
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
import io.jsonwebtoken.io.Decoders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

<<<<<<< HEAD
=======
/**
 * This service handles all methods related to JWT token:
 * validating it.
 * creating it.
 * setting its expiration.
 */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
@Service
public class JwtService {
    private String secretStringKey = "2A472D4B6150645367566B58703273357638792F423F4528482B4D6251655468";
    private Key secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretStringKey));
<<<<<<< HEAD
=======

    /**
     * generates JWT token.
     * @param userDetails: user trying to login.
     * @return: jwt token string.
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put(JwtEnum.Authority.toString(), userDetails.getAuthorities());
        return encodeTheUserWithClaims(userDetails, claimsMap);
    }
<<<<<<< HEAD
    private String encodeTheUserWithClaims(UserDetails userDetails, Map<String, Object> claimsMap) {
=======

    /**
     * encode the token with additional claims added.
     * @param userDetails: user
     * @param claimsMap: claims added.
     * @return: modified token.
     */
    public String encodeTheUserWithClaims(UserDetails userDetails, Map<String, Object> claimsMap) {
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
        String token = Jwts.builder()
                .setClaims(claimsMap)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
<<<<<<< HEAD
                .setExpiration(new Date(System.currentTimeMillis() + hoursToMiliseconds(10)))
=======
                .setExpiration(new Date(System.currentTimeMillis() + hoursToMiliseconds(JwtNumbers.JwtTokenHours.getValue())))
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
                .signWith(secretKey, SignatureAlgorithm.HS256).compact();

        return token;
    }
<<<<<<< HEAD
    private long hoursToMiliseconds(int hour) {
        int milisecond = hour * 60 * 60 * 1000;
        return milisecond;
    }

=======

    /**
     * helper function to convert hour to milisecond.
     * @param hour: hour
     * @return: time in miliseconds.
     */
    public long hoursToMiliseconds(int hour) {
        int milisecond = hour * JwtNumbers.Seconds.getValue() * JwtNumbers.Minutes.getValue() * JwtNumbers.Miliseconds.getValue();
        return milisecond;
    }

    /**
     * fetches username
     * @param jwtToken: jwtToken
     * @return: username contained in token.
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    public String getUsername(String jwtToken) {
        Claims claims = getAllClaims(jwtToken);
        return claims.getSubject();
    }

<<<<<<< HEAD
=======
    /**
     * fetches expiration date.
     * @param jwtToken: jwt token
     * @return: date of expiration.
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    public Date getEpirationDate(String jwtToken) {
        return getAllClaims(jwtToken).getExpiration();
    }

<<<<<<< HEAD
=======
    /**
     * checks of token is valid.
     * @param jwtToken: jwt token
     * @param userDetails: user.
     * @return: boolean if toke is valid or not.
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    public boolean isValid(String jwtToken, UserDetails userDetails) {
        String username = getUsername(jwtToken);
        if(!isExpired(jwtToken) && userDetails.getUsername().equals(username)) {
            return true;
        }
        return false;
    }

<<<<<<< HEAD
=======

    /**
     * checks if token is expired.
     * @param jwtToken: jwt token.
     * @return: boolean if token is expired or not.
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    private boolean isExpired(String jwtToken) {
        if(getEpirationDate(jwtToken).before(new Date())){
            return true;
        }
        return false;
    }

<<<<<<< HEAD
=======
    /**
     * fetches all claims contained by token.
     * @param jwtToken: jwt token
     * @return: claims added.
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    private Claims getAllClaims(String jwtToken){
         return (Claims)Jwts.parserBuilder().setSigningKey(secretKey).build().parse(jwtToken).getBody();
    }
}
