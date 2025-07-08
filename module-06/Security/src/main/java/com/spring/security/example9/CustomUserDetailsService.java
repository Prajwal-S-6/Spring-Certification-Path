package com.spring.security.example9;

import com.spring.security.example9.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersDao.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
