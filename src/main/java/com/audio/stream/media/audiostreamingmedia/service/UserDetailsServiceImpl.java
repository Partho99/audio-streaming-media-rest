package com.audio.stream.media.audiostreamingmedia.service;

import com.audio.stream.media.audiostreamingmedia.entities.User;
import com.audio.stream.media.audiostreamingmedia.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmailOrUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Email/Username " + username + " not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                getGrantedAuthority(user));
    }

    public Collection<GrantedAuthority> getGrantedAuthority(User user) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (user.getRole().getName().equalsIgnoreCase("admin")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        authorities.add(new SimpleGrantedAuthority("ROL_USER"));
        return authorities;
    }
}
