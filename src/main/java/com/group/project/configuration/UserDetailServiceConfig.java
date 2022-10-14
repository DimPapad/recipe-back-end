package com.group.project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 *
 * @author Andreas
 */
@Configuration
public class UserDetailServiceConfig {

    /*@Bean
    //public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password(encoder.encode("123"))
                .roles("USER")
                .build());
        manager.createUser(User.withUsername("admin")
                .password(encoder.encode("123"))
                .roles("ADMIN", "USER")
                .build());
        return manager;
    }*/
        
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
