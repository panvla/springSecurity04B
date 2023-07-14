package com.vladimirpandurov.springSecurity04B.repository;

import com.vladimirpandurov.springSecurity04B.domain.User;
import com.vladimirpandurov.springSecurity04B.dto.UserDTO;

import java.util.Collection;

public interface UserRepository<T extends User> {
    /*Basic CRUD Operations*/
    T create(T data);
    Collection<T> list(int page, int pageSize);
    T get(Long id);
    T update(T data);
    Boolean delete(Long id);

    T getUserByEmail(String email);
    void sendVerificationCode(UserDTO user);
    T verifyCode(String email, String code);
    void resetPassword(String email);
    T verifyPasswordKey(String key);
    void renewPassword(String key,String password,String confirmPassword);
    T verifyAccountKey(String key);
}
