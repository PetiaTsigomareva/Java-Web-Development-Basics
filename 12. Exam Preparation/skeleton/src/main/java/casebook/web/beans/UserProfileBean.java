package casebook.web.beans;

import casebook.domain.models.service.UserServiceModel;
import casebook.domain.models.view.UserProfileViewModel;
import casebook.service.UserService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class UserProfileBean {
    private UserProfileViewModel userProfileViewModel;

    private UserService userService;

    private ModelMapper modelMapper;

    public UserProfileBean() {
    }

    @Inject
    public UserProfileBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.initModel();
    }

    private void initModel() {

        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        UserServiceModel userServiceModel = this.userService.findByID(id);

        if (userServiceModel == null) {
            throw new IllegalArgumentException("The user does not exist");
        }
        this.userProfileViewModel = this.modelMapper.map(userServiceModel, UserProfileViewModel.class);
    }

    public UserProfileViewModel getUserProfileViewModel() {
        return userProfileViewModel;
    }

    public void setUserProfileViewModel(UserProfileViewModel userProfileViewModel) {
        this.userProfileViewModel = userProfileViewModel;
    }
}
