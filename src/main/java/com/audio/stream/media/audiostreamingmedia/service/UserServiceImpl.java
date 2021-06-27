package com.audio.stream.media.audiostreamingmedia.service;

import com.audio.stream.media.audiostreamingmedia.entities.User;
import com.audio.stream.media.audiostreamingmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements IService<User> {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveOrUpdate(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public String deleteById(Long id) {
        userRepository.deleteById(id);
        return "Successfully deleted";
    }
}
