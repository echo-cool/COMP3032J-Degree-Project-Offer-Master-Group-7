package com.group7.utils.common;

/**
 * @Author: WangYuyang
 * @Date: 2023/3/2-17:48
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.utils.common
 * @Description:
 **/
import java.util.Date;

import com.group7.controller.user.UserDetailsImpl;
import com.group7.db.jpa.User;
import com.group7.db.jpa.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${bezkoder.app.jwtSecret}")
    private String jwtSecret;

    @Value("${bezkoder.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Autowired
    private UserRepository userRepository;

    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(String.valueOf(userPrincipal.getId()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public long getUserIdFromJwtToken(String token){
        String idStr = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
        return Long.parseLong(idStr);
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error(authToken);
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

    private String parseJwt(HttpServletRequest request) {
        return getJwtString(request, logger);
    }

    public static String getJwtString(HttpServletRequest request, Logger logger) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {

            if(headerAuth.contains("Bearer 20")) {
                headerAuth = headerAuth.replace("Bearer 20", "");
            }else{
                headerAuth = headerAuth.substring(7);
            }
            logger.info(headerAuth);
            return headerAuth;
        }

        return null;
    }

    /**
     * Find out the user by using the token in the request header.
     * @param request a http request with the token in its header
     */
    public User getUserFromRequestByToken(HttpServletRequest request){
        // get token from the request header
        String token = parseJwt(request);

        // get user id from token
        long userId = getUserIdFromJwtToken(token);
        // query user from db
        if(!userRepository.existsById(userId)){
            return null;
        }
        if(userRepository.findById(userId).isPresent()){
            return userRepository.findById(userId).get();
        }
        else{
            return null;
        }
    }
}