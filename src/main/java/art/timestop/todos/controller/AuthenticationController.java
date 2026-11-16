package art.timestop.todos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import art.timestop.todos.dto.RegisterDto;
import art.timestop.todos.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/api/auth")
@Tag (name = "Authentication REST API Endpoints", description = "Register and Login operations")
public class AuthenticationController {
    
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Operation (summary = "Register a user")
    @ResponseStatus (HttpStatus.CREATED)
    @PostMapping ("/register")
    public void register(@Valid @RequestBody RegisterDto registerDto) throws Exception {
        authenticationService.register(registerDto);
    }
}
