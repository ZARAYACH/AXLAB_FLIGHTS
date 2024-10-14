package com.axlab.flights.security;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.axlab.flights.exeption.AuthenticationInvalidTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.interfaces.RSAPublicKey;
import java.util.Calendar;

@Service
@RequiredArgsConstructor
public class JwtValidationService {

    private final JwkProvider jwkProvider;

    public void validate(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            Jwk jwk = jwkProvider.get(jwt.getKeyId());
            Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) jwk.getPublicKey(), null);
            if (jwt.getExpiresAt().before(Calendar.getInstance().getTime())) {
                throw new AuthenticationInvalidTokenException("Token expired !!");
            }
            algorithm.verify(jwt);
        } catch (JwkException e) {
            throw new AuthenticationInvalidTokenException("Invalid token", e);
        }
    }
    public DecodedJWT decode(String token){
        return JWT.decode(token);
    }
}


