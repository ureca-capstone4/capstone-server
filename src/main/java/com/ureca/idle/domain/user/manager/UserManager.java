package com.ureca.idle.domain.user.manager;

import com.ureca.idle.domain.user.entity.Role;
import com.ureca.idle.domain.user.entity.User;
import com.ureca.idle.domain.user.exception.UserNotFoundException;
import com.ureca.idle.domain.user.persistence.UserRepository;
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

    public User getUserByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new UserNotFoundException("해당 이메일, 혹은 비밀번호를 가진 유저를 찾을 수 없습니다."));
    }

    public User registerUser(String email, String password) {
        User newUser = User.builder()
                .email(email)
                .password(password)
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
