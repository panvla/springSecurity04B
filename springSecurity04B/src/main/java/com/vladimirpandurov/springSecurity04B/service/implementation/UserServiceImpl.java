package com.vladimirpandurov.springSecurity04B.service.implementation;

import com.vladimirpandurov.springSecurity04B.domain.Role;
import com.vladimirpandurov.springSecurity04B.domain.User;
import com.vladimirpandurov.springSecurity04B.dto.UserDTO;
import com.vladimirpandurov.springSecurity04B.dtomapper.UserDTOMapper;
import com.vladimirpandurov.springSecurity04B.repository.RoleRepository;
import com.vladimirpandurov.springSecurity04B.repository.UserRepository;
import com.vladimirpandurov.springSecurity04B.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.vladimirpandurov.springSecurity04B.dtomapper.UserDTOMapper.fromUser;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository<User> userRepository;
    private final RoleRepository<Role> roleRepository;

    public UserDTO createUser(User user){

        return mapToUserDTO(userRepository.create(user));
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return mapToUserDTO(userRepository.getUserByEmail(email));
    }

    @Override
    public void sendVerificationCode(UserDTO user) {
        this.userRepository.sendVerificationCode(user);
    }

    @Override
    public UserDTO verifyCode(String email, String code) {
        return mapToUserDTO(userRepository.verifyCode(email, code));
    }

    @Override
    public void resetPassword(String email) {
        this.userRepository.resetPassword(email);
    }

    @Override
    public UserDTO verifyPasswordKey(String key) {
        return mapToUserDTO(this.userRepository.verifyPasswordKey(key));
    }

    @Override
    public void renewPassword(String key, String password, String confirmPassword) {
        this.userRepository.renewPassword(key, password, confirmPassword);
    }

    @Override
    public UserDTO verifyAccount(String key) {
        return mapToUserDTO(this.userRepository.verifyAccountKey(key));
    }

    public UserDTO mapToUserDTO (User user) {
        return fromUser(user, roleRepository.getRoleByUserId(user.getId()));
    }
}
