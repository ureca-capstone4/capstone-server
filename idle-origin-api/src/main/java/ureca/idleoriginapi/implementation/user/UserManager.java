package ureca.idleoriginapi.implementation.user;

import com.ureca.idle.jpa.user.Role;
import com.ureca.idle.jpa.user.User;
import com.ureca.idle.originapi.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserManager {

    private final UserRepository repository;

    public User getUser(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserException(UserExceptionType.ID_NOT_FOUND_EXCEPTION));
    }

    public User getUserByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UserException(UserExceptionType.EMAIL_NOT_FOUND_EXCEPTION));
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new UserException(UserExceptionType.EMAIL_OR_PASSWORD_NOT_FOUND_EXCEPTION));
    }

    // TODO AuthManager 생성 고려
    public User getCurrentLoginUser(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserException(UserExceptionType.LOGIN_USER_NOT_FOUND_EXCEPTION));
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

    public void checkExistsUserByEmail(String email) {
        if(repository.existsByEmail(email)) {
            throw new UserException(UserExceptionType.EMAIL_ALREADY_EXITS_EXCEPTION);
        }
    }
}
