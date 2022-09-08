package com.globallogic.HotelBookingManagementSystem.jwt;

import com.globallogic.HotelBookingManagementSystem.service.jwtService.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private static final long serialVersionUID = 1L;

    @Value("${mbps.jwt.secretKey}")
    private String secretKey;

    @Value("${mbps.jwt.expirationTime}")
    private long expirationTime;
    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
//        Date date = new Date();
        Map<String,Object> claims = new HashMap<>();

        //Getting current time of the system in milliseconds
        final long currentTime = System.currentTimeMillis();

        String encodedString = Base64.getEncoder().encodeToString(secretKey.getBytes());

        System.err.println(secretKey);
        System.err.println(expirationTime);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date(currentTime))
                .setExpiration(new Date(currentTime+expirationTime))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        String encodedString = Base64.getEncoder().encodeToString(secretKey.getBytes());
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            String encodedString = Base64.getEncoder().encodeToString(secretKey.getBytes());
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
            System.err.println("JwtUtils/validateToken: valid");
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

//    //Generating and returning the JWT from user details
//    public String generateTokenFromUserDetails(UserDetails userDetails) {
//
//        //Creating claim which will contain all JWT related details
//        Map<String, Object> claims = new HashMap<>();
//
//        //Getting current time of the system in milliseconds
//        final long currentTime = System.currentTimeMillis();
//
//        //Return the JWT after building it
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date(currentTime))
//                .setExpiration(new Date(currentTime+JWT_VALIDITY))
//                .signWith(SignatureAlgorithm.HS512,secretKey)
//                .compact();
//    }
//
//    //Retrieving all information we need related to a token in form of Claims
//    private Claims getClaimFromToken(String token){
//        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
//    }
//
//    //Retrieving username from a token
//    public String getUsernameFromToken(String token){
//        return getClaimFromToken(token).getSubject();
//    }
//
//    //Retrieving expiration date from token
//    public Date getExpirationDateFromToken(String token) {
//        return getClaimFromToken(token).getExpiration();
//    }
//
//    //Checking if token is expired
//    private Boolean tokenIsExpired(String token){
//        return getExpirationDateFromToken(token).before(new Date());
//    }
//
//    //Checking if token is valid
//    public Boolean tokenIsValid(String token, UserDetails userDetails){
//        final String username = getUsernameFromToken(token);
//        return username.equals(userDetails.getUsername()) && !tokenIsExpired(token);
//    }


}
