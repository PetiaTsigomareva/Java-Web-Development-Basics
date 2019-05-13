package exam.domain.models.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegistrationBindingModel {
    private String userName;
    private String password;
    private String confirmPassword;
    private String email;

    public UserRegistrationBindingModel() {
    }

    @NotNull(message = "can not be empty!")
    @Size(min = 1, message = "can not be empty")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @NotNull(message = "can not be empty!")
    @Size(min = 1, message = "can not be empty")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull(message = "can not be empty!")
    @Size(min = 1, message = "can not be empty")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @NotNull(message = "can not be empty!")
    @Size(min = 1, message = "can not be empty")

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
