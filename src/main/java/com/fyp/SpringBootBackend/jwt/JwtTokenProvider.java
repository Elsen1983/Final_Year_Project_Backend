package com.fyp.SpringBootBackend.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class JwtTokenProvider {

    @Value("${app.jwt.secret}")
    private String jwtSecret;

    @Value("${app.jwt.token.prefix}")
    private String jwtTokenPrefix;

    @Value("${app.jwt.header.string}")
    private String jwtHeaderString;

    long exp = System.currentTimeMillis() + 86400000;

    public String generateToken(Authentication authentication){
        String authorities = authentication.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining());

        return Jwts.builder().setSubject(authentication.getName())
                .claim("roles", authorities)
                .setExpiration(new Date(exp))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    public Authentication getAuthentication(HttpServletRequest request){
        String token = resolveToken(request);
        if(token == null){
            System.out.println("Missing token...");
            return null;
        }
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        } catch(Exception  e){
            System.out.println("Invalid JWT token format: " + e.getMessage());
        }
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        String username = claims.getSubject();
        List<GrantedAuthority> authorities = Arrays.stream(claims.get("roles").toString().split(","))
                .map(role -> role.startsWith("ROLE_")? role:"ROLE_"+role)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return username!=null ? new UsernamePasswordAuthenticationToken(username, null, authorities):null;
    }

    public boolean validateToken(HttpServletRequest request){
        String token = resolveToken(request);

        if(token == null){
            System.out.println("Missing token...");
            return false;
        }

        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();

        if(claims.getExpiration().before(new Date())){
            System.out.println("Expired token...");
            return false;
        }

        System.out.println("Valid token...");
        return true;
    }

    private String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader(jwtHeaderString);
        if(bearerToken!=null && bearerToken.startsWith(jwtTokenPrefix)){
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

}
