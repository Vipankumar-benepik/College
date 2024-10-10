package com.college_mgmt.college.Services;

import com.college_mgmt.college.Entites.Users;
import com.college_mgmt.college.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> userDetail = userRepository.findByUsername(username);
        System.out.println(userDetail);
        return userDetail.map(UserInfoDetails:: new).orElseThrow(() -> new UsernameNotFoundException("User not Found"+username));
    }
}
