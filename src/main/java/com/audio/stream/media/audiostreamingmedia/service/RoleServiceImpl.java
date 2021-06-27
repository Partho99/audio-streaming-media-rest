package com.audio.stream.media.audiostreamingmedia.service;

import com.audio.stream.media.audiostreamingmedia.entities.Role;
import com.audio.stream.media.audiostreamingmedia.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService<Role> {

    final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Collection<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role saveOrUpdate(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public String deleteById(Long id) {
        roleRepository.deleteById(id);
        return " successfully deleted";
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
