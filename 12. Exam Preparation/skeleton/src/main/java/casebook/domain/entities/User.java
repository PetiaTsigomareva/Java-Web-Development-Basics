package casebook.domain.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String username;
    private String password;
    private GenderEnum gender;
    private List<User> friends;

    public User() {
        this.friends = new ArrayList<>();
    }

    @Column(name = "username", nullable = false, unique = true, updatable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
    @ManyToMany(targetEntity = User.class)
    @JoinTable(
            name ="users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id")
    )
    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}
