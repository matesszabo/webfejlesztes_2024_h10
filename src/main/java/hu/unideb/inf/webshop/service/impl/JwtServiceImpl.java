package hu.unideb.inf.webshop.service.impl;

import hu.unideb.inf.webshop.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtServiceImpl implements JwtService {
    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public String generateToken(UserDetails userDetails) {//UserDetails, Map<String, Object>
        Map<String, Object> extraClaims = new HashMap<>();//public/private claimek

        byte[] keyBytes = Decoders.BASE64.decode("secret");
        Key k = Keys.hmacShaKeyFor(keyBytes);

        return Jwts.builder().claims(extraClaims).subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+300000))
                .signWith(k)
                .compact();
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parser().setSigningKey("secret")
                .build()
                .parseClaimsJws(token)
                .getPayload();

        //claims.getSubject() -- csak felhasználónév kinyerése

        return claimsResolver.apply(claims);
    }
}
