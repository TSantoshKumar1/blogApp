package com.blogapp12.controller;

import com.blogapp12.entity.User;
import com.blogapp12.payload.LoginDto;
import com.blogapp12.payload.Signup;
import com.blogapp12.repository.UserRepository;
import com.blogapp12.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {



    @Autowired
    private UserRepository userRepository;

    @Autowired
   private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;




// http://localhost:8082/api/auth/sign-up

    @PostMapping("/sign-up")
    public ResponseEntity<String>createUser( @RequestBody  Signup signup) {

        if (userRepository.existsByEmail(signup.getEmail())) {
            return new ResponseEntity<>("email id is already registered", HttpStatus.INTERNAL_SERVER_ERROR);
        }


        if (userRepository.existsByUsername(signup.getUsername())) {

            return new ResponseEntity<>("username is alredy registered", HttpStatus.INTERNAL_SERVER_ERROR);

        }

        User user = new User();

        user.setName(signup.getName());
        user.setEmail(signup.getEmail());
        user.setUsername(signup.getUsername());

        user.setPassword(passwordEncoder.encode(signup.getPassword()));

        User saveUser = userRepository.save(user);
        return new ResponseEntity<>("user Registered", HttpStatus.CREATED);
    }




// creating the login user................

    @PostMapping("/sign-in")
    public ResponseEntity<String>signUser( @RequestBody  LoginDto loginDto){


      // UsernamePasswordAuthentication - >  1. it will supply loginDto.getUsername(),loginDto.getPassword()-user details
      // to loadUserByUser method in CustomUserDetails class.

      // 2. then it will compare actual credentials to expected credentials

                UsernamePasswordAuthenticationToken    usernamePasswordAuthenticationToken  =

                        new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword());

      // whatever result we get after comparison either true or false , it set into the authenticationManager.
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // it is act similar to session variable
        SecurityContextHolder.getContext().setAuthentication(authenticate);


        return new ResponseEntity<>("sign-in successful", HttpStatus.OK);
    }



}
