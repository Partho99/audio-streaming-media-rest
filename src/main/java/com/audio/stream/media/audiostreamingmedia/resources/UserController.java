package com.audio.stream.media.audiostreamingmedia.resources;

import com.audio.stream.media.audiostreamingmedia.configuration.JwtTokenProvider;
import com.audio.stream.media.audiostreamingmedia.entities.User;
import com.audio.stream.media.audiostreamingmedia.repository.RoleRepository;
import com.audio.stream.media.audiostreamingmedia.repository.UserRepository;
import com.audio.stream.media.audiostreamingmedia.utils.ConstantUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {


    private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public UserController(JwtTokenProvider tokenProvider, AuthenticationManager authenticationManager, RoleRepository roleRepository, UserRepository userRepository) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> register(@RequestBody User user) {
        LOGGER.info("UserResourceImpl : register");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setRole(roleRepository.findByName(ConstantUtils.USER.toString()));
        User savedUser = userRepository.saveAndFlush(user);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> authenticate(@RequestBody User user) {
        LOGGER.info("UserResourceImpl : authenticate");


        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            String email = user.getEmail();
            User loggedInUser = userRepository.findByEmailOrUsername(email);
            String token = tokenProvider.createToken(email, userRepository.findByEmailOrUsername(email).getRole());
            user.setToken(token);
            return new ResponseEntity<User>(loggedInUser, HttpStatus.OK);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


}
