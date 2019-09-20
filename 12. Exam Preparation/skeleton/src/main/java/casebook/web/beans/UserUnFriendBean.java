package casebook.web.beans;

import casebook.domain.models.service.UserServiceModel;
import casebook.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Named
@RequestScoped
public class UserUnFriendBean {
    private UserService userService;

    public UserUnFriendBean() {
    }

    @Inject
    public UserUnFriendBean(UserService userService) {
        this.userService = userService;
        this.init();
    }

    private void init()

    {


    }

    public void unFriend(String id) throws IOException {
        String loggedUserId = (String) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("userId");
        UserServiceModel loggedUser = this.userService.findByID(loggedUserId);
        UserServiceModel friendUser = this.userService.findByID(id);

        List<UserServiceModel> loggedUserFriends=loggedUser.getFriends();
        List<UserServiceModel> friendUserFriends=friendUser.getFriends();

        for (UserServiceModel f : loggedUserFriends) {
            if (f.getUsername().equals(friendUser.getUsername())) {
                loggedUserFriends.remove(f);
                this.userService.unFriend(loggedUser);
            }

        }

        for (UserServiceModel f:friendUserFriends) {
            if(f.getUsername().equals(loggedUser.getUsername())){
                friendUserFriends.remove(f);
            this.userService.unFriend(friendUser);
            }

        }

        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/friends");


    }
}
