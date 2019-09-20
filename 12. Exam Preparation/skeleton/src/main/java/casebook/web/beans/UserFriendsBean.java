package casebook.web.beans;

import casebook.domain.models.view.UserFriensViewModel;
import casebook.service.UserService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class UserFriendsBean {
    private List<UserFriensViewModel> friends;

    private UserService userService;

    private ModelMapper modelMapper;

    public UserFriendsBean() {
    }

    @Inject
    public UserFriendsBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;

        this.initModel();
    }

    private void initModel() {
        String id = (String) (((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession()).getAttribute("userId");

        this.friends = this.userService.findByID(id).getFriends().stream().map(f -> this.modelMapper.map(f, UserFriensViewModel.class)).collect(Collectors.toList());


    }

    public List<UserFriensViewModel> getFriends() {
        return friends;
    }

    public void setFriends(List<UserFriensViewModel> friends) {
        this.friends = friends;
    }
}
