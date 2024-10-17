package com.ureca.idle.idleapi.idleoriginapi.implementation.user;

import com.ureca.idle.idleapi.idleoriginapi.common.exception.UserNotFoundException;
import com.ureca.idle.idleapi.idleoriginapi.persistence.user.UserRepository;
import com.ureca.idle.idlejpa.user.Role;
import com.ureca.idle.idlejpa.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserManager {

    private final UserRepository repository;

    public User getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("해당 ID 를 가진 유저를 찾을 수 없습니다."));
    }

    public User getUserByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("해당 이메일을 가진 유저를 찾을 수 없습니다."));
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new UserNotFoundException("해당 이메일, 혹은 비밀번호를 가진 유저를 찾을 수 없습니다."));
    }

    // TODO AuthManager 생성 고려
    public User getCurrentLoginUser(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("현재 로그인한 유저를 찾을 수 없습니다, 다시 로그인해주세요."));
    }

    public void checkCurrentLoginUser(String email) {
        if(!repository.existsByEmail(email)) {
            throw new UserNotFoundException("현재 로그인한 유저를 찾을 수 없습니다, 다시 로그인해주세요.");
        }
    }

    public User registerUser(String email, String password, String name, String phoneNum) {
        User newUser = User.builder()
                .email(email)
                .password(password)
                .name(name)
                .phoneNum(phoneNum)
                .role(Role.USER)
                .build();
        return repository.save(newUser);
    }

    public void checkExitsUserByEmail(String email) {
        if(repository.existsByEmail(email)) {
            throw new UserNotFoundException("이미 해당 이메일을 가진 유저가 존재합니다.");
        }
    }
}
