package art.timestop.todos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import art.timestop.todos.dto.response.UserInfoResponse;
import art.timestop.todos.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;


@Tag (name = "User REST API endpoints")
@RestController 
@RequestMapping ("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/info")
    public UserInfoResponse getUserInfo() {
        return userService.getUserInfo(

        );
    }
    
    
}
