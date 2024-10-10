package com.college_mgmt.college.RestController;

import com.college_mgmt.college.Dto.UserDto;
import com.college_mgmt.college.Entites.Users;
import com.college_mgmt.college.Repositories.UserRepository;
import com.college_mgmt.college.Services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

//        String jwt = jwtUtils.generateToken(user.getUsername());
        return ResponseEntity.ok(jwtService.generateToken(userDto.getUsername()));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Users users){
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        Users savedUser = userRepository.save(users);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/getAPI")
    public ResponseEntity<?> registerData(){
        return ResponseEntity.ok("Hello This is some Secure Data");
    }

}
