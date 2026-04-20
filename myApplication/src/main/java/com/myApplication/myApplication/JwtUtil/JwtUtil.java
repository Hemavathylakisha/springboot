package com.myApplication.myApplication.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtUtil {
    //secret key generate for signature
    static final int EXTTIME=1000*60*60*24;
    static final byte KEY[]="sCK0p1y9TzoVLqk0vY83wiBik15/sv6dmBr4JN54GvazZW9FaDM43TFn0Oz+cr3gesICBj9j9Z/xQ/dEDbV7gA==".getBytes(StandardCharsets.UTF_8);
    static final Key seckretkey=Keys.hmacShaKeyFor(KEY);

    //token generate
    public static String generateToken(String username,String role){
        return Jwts.builder()
                .claim("Username",username)
                .claim("roles",role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXTTIME))
                .signWith(seckretkey, SignatureAlgorithm.HS512) //header + signature
                .compact();
    }

    //validate token
    public Claims getClaim(String token){
        return Jwts.parserBuilder()
                .setSigningKey(seckretkey)
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }

    //return token validates
    public boolean validate(String token){
        try{
            getClaim(token);
            return true;
        }catch(JwtException e){
            return false;
        }
    }

    //extract user info from token
    public String extractUsername(String token){
        Claims claim=getClaim(token);
        return (String) claim.get("username");
    }
    public String extractRole(String token){
        Claims claim=getClaim(token);
        return (String) claim.get("role");
    }
}
