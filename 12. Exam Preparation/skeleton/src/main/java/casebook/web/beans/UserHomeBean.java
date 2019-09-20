package casebook.web.beans;

import casebook.domain.models.service.UserServiceModel;
import casebook.domain.models.view.UserHomeViewModel;
import casebook.service.UserService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class UserHomeBean {
    private List<UserHomeViewModel> users;
    private UserService userService;
    private ModelMapper modelMapper;

    public UserHomeBean() {
    }

    @Inject
    public UserHomeBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.initModels();
    }

    private void initModels() {
        String username = (String) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("username");

        String id = (String) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("userId");

        UserServiceModel loggedInUser = this.userService.findByID(id);

        this.users = this.userService.getAllUsers().stream().filter(u -> !u.getUsername().equals(username) && !loggedInUser.getFriends().stream().map(f -> f.getUsername()).collect(Collectors.toList()).contains(u.getUsername())).map(u -> this.modelMapper.map(u, UserHomeViewModel.class)).collect(Collectors.toList());
    }

    public List<UserHomeViewModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserHomeViewModel> users) {
        this.users = users;
    }

    public void addFriends(String id) throws IOException {
        String loggedUserId = (String) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("userId");
        UserServiceModel loggedUser = this.userService.findByID(loggedUserId);
        UserServiceModel friendUser = this.userService.findByID(id);

        loggedUser.getFriends().add(friendUser);
        friendUser.getFriends().add(loggedUser);

        if (!this.userService.addFriend(loggedUser)) {
            throw new IllegalArgumentException("Error:Logged user can not add friend choose User!");
        }

        if (!this.userService.addFriend(friendUser)) {
            throw new IllegalArgumentException("Error:Chosen User can not add friend Logged User!");
        }

        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/home");
    }
}
