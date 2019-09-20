package casebook.domain.models.binding;

import javax.validation.constraints.NotNull;

public class UserLoginBindingModel {
    private String userName;
    private String password;

    public UserLoginBindingModel() {
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
}
