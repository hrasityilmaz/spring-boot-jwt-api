package art.timestop.todos.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class RegisterDto {
    @NotEmpty (message = "First name cant be empty")
    @Size (min = 3, max = 30, message = "First name must be between 3-30 characters !")
    private String firstName;

    @NotEmpty (message = "Last name cant be empty")
    @Size (min = 3, max = 30, message = "Last name must be between 3-30 characters !")
    private String lastName;

    @NotEmpty (message = "Email cant be empty")
    @Email (message = "Must be valid email")
    @Size (max = 100, message = "Email cant be more then 100 characters !")
    private String email;

    @NotEmpty (message = "Password cant be empty")
    @Size (min = 5, message = "Password must be at least 5 characters !")
    private String password;

    public RegisterDto() {}

    public RegisterDto(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
