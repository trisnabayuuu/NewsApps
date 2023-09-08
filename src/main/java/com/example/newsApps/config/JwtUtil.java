package com.example.newsApps.config;

import java.time.Instant;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

@Component
public class JwtUtil {
    private final String JWT_SECRET_KEY = "libraryfazztrackbcasecretkey";
    private final Long JWT_EXPIRATION_MS = 1 * 30 * 60 * 1000L;

    /*
     * create token from email
     */
    public String createToken(String email) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET_KEY);
            Instant issuedAt = Instant.now();
            String token = JWT.create()
                    .withIssuer("newsapp")
                    .withSubject("auth")
                    .withIssuedAt(issuedAt)
                    .withExpiresAt(issuedAt.plusMillis(JWT_EXPIRATION_MS))
                    .withClaim("username", email)
                    .sign(algorithm);

            return token;
        } catch (JWTCreationException exception) {
            // Invalid Signing configuration / Couldn't convert Claims.
            return null;
        }
    }

    /*
     * validate token
     */
    public Boolean validateToken(String token) {
        try {
            verifyToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * private method untuk verify token yang mengembalikan decoded jwtnya
     */
    private DecodedJWT verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    // specify an specific claim validations
                    .withIssuer("newsapp")
                    // reusable verifier instance
                    .build();

            DecodedJWT decodedJWT = verifier.verify(token);
            return decodedJWT;
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    /*
     * get username data from token -> untuk request selanjutnya yg datang bersama
     * token, dicek username
     */
    public String getUsernameFromToken(String token) {
        try {
            DecodedJWT decodedJWT = verifyToken(token);
            String username = decodedJWT.getClaim("username").asString();
            return username;
        } catch (Exception e) {
            return null;
        }
    }
}