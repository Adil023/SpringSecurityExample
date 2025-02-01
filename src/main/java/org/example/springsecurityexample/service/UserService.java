package org.example.springsecurityexample.service;

import org.example.springsecurityexample.modle.User;
import org.example.springsecurityexample.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UserRepository repo;


    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public void register(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println("my password: "+user.getPassword());
       repo.save(user);
    }

    public String verify(User user){ // bad credentials exception
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUsername(),user.getPassword()
        ));

        if(authentication.isAuthenticated()){
           // System.out.println(jwtService.generateToken(user.getUsername()));
            return jwtService.generateToken(user.getUsername());
        }

        return "fail";
    }


    }
