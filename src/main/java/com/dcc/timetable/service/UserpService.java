package com.dcc.timetable.service;

import java.util.ArrayList;

import com.dcc.timetable.dao.UserpDao;
import com.dcc.timetable.domain.Role;
import com.dcc.timetable.domain.Userp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service("userDetailsService")          
@Slf4j
public class UserpService implements UserDetailsService{

    @Autowired
    private UserpDao userpDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Userp user = userpDao.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException(username);
        }

        var roles = new ArrayList<GrantedAuthority>();

        for(Role role: user.getRoles()){
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new User(user.getUsername(), user.getPassword(), roles);
    }
    
}
