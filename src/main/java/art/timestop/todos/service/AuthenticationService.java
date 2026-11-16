package art.timestop.todos.service;

import art.timestop.todos.dto.RegisterDto;

public interface AuthenticationService {
    void register(RegisterDto input) throws Exception;
}
