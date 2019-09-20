package casebook.domain.models.service;

import casebook.domain.entities.GenderEnum;
import casebook.domain.entities.User;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class UserServiceModel {

    private String id;
    private String username;
    private String password;
    private GenderEnum gender;
    private List<UserServiceModel> friends;

    public UserServiceModel() {
        this.friends = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotNull
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public List<UserServiceModel> getFriends() {
        return friends;
    }

    public void setFriends(List<UserServiceModel> friends) {
        this.friends = friends;
    }
}
