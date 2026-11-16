package art.timestop.todos.service;

import art.timestop.todos.dto.request.RegisterDto;

public interface AuthenticationService {
    void register(RegisterDto input) throws Exception;
}
