package app.web.beans;

import app.domain.models.binding.UserRegisterBindingModel;
import app.domain.models.service.UserServiceModel;
import app.service.UserService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class UserRegisterBean {
    private UserRegisterBindingModel model;

    private UserService userService;
    private ModelMapper modelMapper;

    public UserRegisterBean() {
    }

    @Inject
    public UserRegisterBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.model = new UserRegisterBindingModel();
    }

    public UserRegisterBindingModel getModel() {
        return this.model;
    }

    public void setModel(UserRegisterBindingModel model) {
        this.model = model;
    }

    public void register() throws IOException {
        if (!this.model.getPassword().equals(this.model.getConfirmPassword())){
            throw new IllegalArgumentException("Passwords don`t match");
        }

        if (!this.userService.registerUser(this.modelMapper.map(this.model, UserServiceModel.class))){
            throw new IllegalArgumentException("Something went wrong");
        }

        FacesContext.getCurrentInstance().getExternalContext().redirect("/view/login.jsf");
    }
}
