package devcrema.spring_boot_toy.test_fixture;

import devcrema.spring_boot_toy.user.User;
import devcrema.spring_boot_toy.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserFixtureGenerator {

    public static final String EMAIL = "test@test.com";
    public static final String NICKNAME = "nickname";
    public static final String PASSWORD = "123456789a";

    public static User generateUser (UserRepository userRepository, PasswordEncoder userPasswordEncoder) {
        Optional<User> optionalUser = userRepository.findByEmail(EMAIL);
        return optionalUser.orElseGet(() -> userRepository.save(User.builder()
                .email(EMAIL)
                .nickname(NICKNAME)
                .password(userPasswordEncoder.encode(PASSWORD)).build()));
    }
}
