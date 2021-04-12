package tcu.webtech.superfrogscheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import tcu.webtech.superfrogscheduler.models.ERole;
import tcu.webtech.superfrogscheduler.models.Role;
import tcu.webtech.superfrogscheduler.models.User;
import tcu.webtech.superfrogscheduler.repositories.UserRepository;
import tcu.webtech.superfrogscheduler.services.CustomUserDetails;
import tcu.webtech.superfrogscheduler.services.CustomUserDetailsService;
import tcu.webtech.superfrogscheduler.repositories.RoleRepository;

@Component
public class DBDataInitializer implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
//    @Autowired
//    private CustomUserDetailsService userService;
    @Override
    public void run(String... args) throws Exception {

        // We must initialize the roles in the DB for them to be recognized by login/signup
        Role r1 = new Role(ERole.ROLE_CUSTOMER);
        Role r2 = new Role(ERole.ROLE_SUPERFROG);
        Role r3 = new Role(ERole.ROLE_SPIRITDIRECTOR);

        roleRepository.save(r1);
        roleRepository.save(r2);
        roleRepository.save(r3);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword;
        User user1 = new User();
        user1.setEmail("john@gmail.com");
        user1.setPassword("123456");
        encodedPassword = passwordEncoder.encode(user1.getPassword());
        user1.setPassword(encodedPassword);
        user1.setUsername("john");
        User user2 = new User();
        user2.setEmail("eric@gmail.com");
        user2.setPassword("654321");
        encodedPassword = passwordEncoder.encode(user2.getPassword());
        user2.setPassword(encodedPassword);
        user2.setUsername("eric");
        User user3 = new User();
        user3.setEmail("tom@gmail.com");
        user3.setPassword("123");
        encodedPassword = passwordEncoder.encode(user3.getPassword());
        user3.setPassword(encodedPassword);
        user3.setUsername("tom");
        User user4 = new User();
        user4.setEmail("jack@gmail.com");
        user4.setPassword("321");
        encodedPassword = passwordEncoder.encode(user4.getPassword());
        user4.setPassword(encodedPassword);
        user4.setUsername("jack");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
//        userService.save(u1);
//        userService.save(u2);
//        userService.save(u3);
    }
}
