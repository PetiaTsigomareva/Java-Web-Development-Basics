package casebook.web.beans;

import casebook.domain.entities.GenderEnum;
import casebook.domain.models.binding.UserRegistrationBindingModel;
import casebook.domain.models.service.UserServiceModel;
import casebook.service.UserService;
import org.modelmapper.ModelMapper;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class UserRegisterBean {
    private UserService userService;
    private ModelMapper modelMapper;
    private UserRegistrationBindingModel userRegistrationBindingModel;

    public UserRegisterBean() {
    }

    @Inject
    public UserRegisterBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.initModel();
    }

    private void initModel() {
        this.userRegistrationBindingModel = new UserRegistrationBindingModel();
    }

    public UserRegistrationBindingModel getUserRegistrationBindingModel() {
        return userRegistrationBindingModel;
    }

    public void setUserRegistrationBindingModel(UserRegistrationBindingModel userRegistrationBindingModel) {
        this.userRegistrationBindingModel = userRegistrationBindingModel;
    }

    public void register() throws IOException {

        if (!userRegistrationBindingModel.getPassword().equals(userRegistrationBindingModel.getConfirmPassword())) {
            throw new IllegalArgumentException("Password do not match!");
        }
        UserServiceModel userServiceModel = this.modelMapper.map(userRegistrationBindingModel, UserServiceModel.class);
       // userServiceModel.setGender(GenderEnum.valueOf(userRegistrationBindingModel.getGender()));
        if (!this.userService.registerUser(userServiceModel)) {
            throw new IllegalArgumentException("The user can not be persist - may be user exist yet!");
        }

        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/login");
    }


}
