package art.timestop.todos.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginRequestDto {

    @NotEmpty(message = "Email cant be empty")
    @Email (message = "Must be valid email")
    private String email;

    @NotEmpty(message = "Password cant be empty")
    @Size (min = 5, max = 30, message="Password must be at kease 5 character")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    

}
