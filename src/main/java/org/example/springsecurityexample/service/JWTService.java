package org.example.springsecurityexample.service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    private String SECRET_KEY = "";
    public JWTService() throws NoSuchAlgorithmException {
        KeyGenerator key = KeyGenerator.getInstance("HmacSHA256");
        SecretKey sKey = key.generateKey();
        this.SECRET_KEY =  Base64.getEncoder().encodeToString(sKey.getEncoded());
    }





    public SecretKey getKey(){
        byte[] byteKey = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(byteKey);
    }

   public String generateToken(String username){
       Map<String,Object> claims = new HashMap<>();

       return Jwts
               .builder()
               .claims()
               .add(claims)
               .subject(username)
               .issuedAt(new Date(System.currentTimeMillis()))
               .expiration(new Date(System.currentTimeMillis()+60*60*20))
               .and()
               .signWith(getKey())
               .compact();
   }
}