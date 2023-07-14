package com.vladimirpandurov.springSecurity04B.service;

import com.vladimirpandurov.springSecurity04B.domain.Role;

public interface RoleService {

    Role getRoleByUserId(Long userId);
}
