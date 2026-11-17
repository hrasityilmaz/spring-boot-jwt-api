package art.timestop.todos.service;


import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import art.timestop.todos.dto.response.AuthorityResponse;
import art.timestop.todos.dto.response.UserInfoResponse;
import art.timestop.todos.entities.User;
import art.timestop.todos.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional (readOnly = true)
	public UserInfoResponse getUserInfo() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if(authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
			throw new AccessDeniedException("Authentication required");
		}

		User user = (User) authentication.getPrincipal();
		return new UserInfoResponse(
            user.getId(),
            user.getFirstName(),
            user.getLastName(),
            user.getEmail(),
            user.getAuthorities().stream()
                .map(auth -> new AuthorityResponse(auth.getAuthority()))
                .toList()
        );
	}


}
