package devcrema.spring_boot_toy.user;

import devcrema.spring_boot_toy.CustomTestConfiguration;
import devcrema.spring_boot_toy.test_fixture.UserFixtureGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomTestConfiguration.class)
@ActiveProfiles(profiles = "test")
@Transactional
public class UserServiceTests {


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserPasswordEncoder userPasswordEncoder;

    @Autowired
    UserService userService;

    @Before
    public void setUp(){
        UserFixtureGenerator.generateUser(userRepository, userPasswordEncoder);
    }

    @Test
    public void testLoadUserByUsername(){
        //given
        String email = UserFixtureGenerator.EMAIL;
        String unExistentEmail = "nothing";

        //when
        User user = (User) userService.loadUserByUsername(email);

        try{
            userService.loadUserByUsername(unExistentEmail);
            fail("exception was not occurred");
        } catch (UsernameNotFoundException ignored){
        }

        //then
        assertThat(user.getEmail()).isEqualTo(email);
    }
}
