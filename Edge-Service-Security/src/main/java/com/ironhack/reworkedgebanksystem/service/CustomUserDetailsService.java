package com.ironhack.reworkedgebanksystem.service;


import com.ironhack.reworkedgebanksystem.controller.DTO.*;
import com.ironhack.reworkedgebanksystem.repository.UserRepository;
import com.ironhack.reworkedgebanksystem.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.*;


import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDTO> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            System.out.println("User not present!");
            throw new UsernameNotFoundException("User does not exist");
        }
        CustomUserDetails customUserDetails = new CustomUserDetails(user.get());
        System.out.println("User found");

        return customUserDetails;
    }


}
