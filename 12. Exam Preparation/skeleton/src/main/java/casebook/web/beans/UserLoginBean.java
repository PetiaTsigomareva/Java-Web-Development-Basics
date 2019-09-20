package casebook.web.beans;

import casebook.domain.models.binding.UserLoginBindingModel;
import casebook.domain.models.service.UserServiceModel;
import casebook.service.UserService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.io.IOException;

@Named
@RequestScoped
public class UserLoginBean {

    private UserService userService;

    private ModelMapper modelMapper;

    private UserLoginBindingModel userLoginBindingModel;

    public UserLoginBean() {
    }

    @Inject
    public UserLoginBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.initModel();
    }

    private void initModel() {
        this.userLoginBindingModel = new UserLoginBindingModel();
    }

    public UserLoginBindingModel getUserLoginBindingModel() {
        return userLoginBindingModel;
    }

    public void setUserLoginBindingModel(UserLoginBindingModel userLoginBindingModel) {
        this.userLoginBindingModel = userLoginBindingModel;
    }

    public void login() throws IOException {
        UserServiceModel userServiceModel = this.userService.loginUser(this.modelMapper.map(this.userLoginBindingModel, UserServiceModel.class));

        if (userServiceModel == null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/login");
            return;

        }

        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpSession.setAttribute("username", userServiceModel.getUsername());
        httpSession.setAttribute("userId", userServiceModel.getId());

        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/home");

    }
}
