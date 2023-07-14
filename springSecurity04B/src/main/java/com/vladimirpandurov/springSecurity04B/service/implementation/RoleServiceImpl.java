package com.vladimirpandurov.springSecurity04B.service.implementation;

import com.vladimirpandurov.springSecurity04B.domain.Role;
import com.vladimirpandurov.springSecurity04B.repository.RoleRepository;
import com.vladimirpandurov.springSecurity04B.service.RoleService;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;


    @Override
    public Role getRoleByUserId(Long userId) {
        return this.roleRepository.getRoleByUserId(userId);
    }
}
