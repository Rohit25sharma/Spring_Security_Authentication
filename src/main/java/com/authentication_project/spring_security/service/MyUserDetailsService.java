package com.authentication_project.spring_security.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.authentication_project.spring_security.model.UserPrincipal;
import com.authentication_project.spring_security.model.Users;
import com.authentication_project.spring_security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUsername(username);

        if(user == null){
            System.out.println("User not Found");
            throw new UsernameNotFoundException("user not found");
        }

        return new UserPrincipal(user);

    }
}
