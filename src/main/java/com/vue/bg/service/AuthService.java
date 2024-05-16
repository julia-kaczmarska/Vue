package com.vue.bg.service;

import com.vue.bg.entity.UserInfoDetails;
import com.vue.bg.model.User;
import com.vue.bg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Optional<User> userDetail = repository.findByName(name);

        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + name));
    }

    public String addUser(User userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        userInfo.setRole(userInfo.getRole());
        repository.save(userInfo);
        return "User Added Successfully";
    }
}
