package org.example.springsecurityexample.service;

import org.example.springsecurityexample.modle.User;
import org.example.springsecurityexample.modle.UserPrincipal;
import org.example.springsecurityexample.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyService implements UserDetailsService {
    @Autowired
    UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user =userRepo.findByUsername(username);
         System.out.println("authentiaction manager sent username :"+username);
         if(user == null){
             System.out.println("user not found");
             throw new UsernameNotFoundException("user not found");
         }
        System.out.println("user found in database :"+ user);

         return new UserPrincipal(user);
    }
}
