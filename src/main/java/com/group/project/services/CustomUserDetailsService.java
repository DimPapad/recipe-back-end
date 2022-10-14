package com.group.project.services;

import com.group.project.models.CustomUserDetails;
import com.group.project.models.User;
import com.group.project.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andreas
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepo.findByEmail(username);
        if (u==null) {
            throw new UsernameNotFoundException("shieeeeet");
        }
        return new CustomUserDetails(u);
    }
    
}
