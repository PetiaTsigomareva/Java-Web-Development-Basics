package casebook.domain.models.binding;

import javax.inject.Named;
import javax.validation.constraints.NotNull;

public class UserRegistrationBindingModel {
    private String userName;
    private String password;
    private String confirmPassword;
    private String gender;

    public UserRegistrationBindingModel() {
    }

    @NotNull

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @NotNull
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}


