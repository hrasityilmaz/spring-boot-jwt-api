package art.timestop.todos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import art.timestop.todos.dto.RegisterDto;
import art.timestop.todos.entities.Authority;
import art.timestop.todos.entities.User;
import art.timestop.todos.enums.Role;
import art.timestop.todos.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service 
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional // Writing to db dont forget !!! 
    public void register(RegisterDto input) throws Exception {
        
        if(isEmailTaken(input.getEmail())){
            throw new Exception("Email already taken!");
        }
        User user = buildNewUser(input);
        userRepository.save(user); 
    }

    private boolean isEmailTaken(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    private List<Authority> initialAuthority() {
        boolean isFirstUser = userRepository.count() == 0;
        List<Authority> authorities = new ArrayList<>();
        authorities.add(new Authority(Role.ROLE_ENPLOYEE.name(), Role.ROLE_ENPLOYEE));
        if (isFirstUser) {
            authorities.add(new Authority(Role.ROLE_ADMIN.name(),Role.ROLE_ADMIN));
        }
        return authorities;
    }

    private User buildNewUser(RegisterDto input) {
        User user = new User();
        user.setId(0);
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setAuthorities(initialAuthority());
        return user;
    }

}
