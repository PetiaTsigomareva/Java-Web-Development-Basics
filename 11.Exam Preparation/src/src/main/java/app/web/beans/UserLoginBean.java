package app.web.beans;

import app.domain.models.binding.UserLoginBindingModel;
import app.domain.models.service.UserServiceModel;
import app.service.UserService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Named
@RequestScoped
public class UserLoginBean {

    private UserLoginBindingModel model;

    private UserService userService;
    private ModelMapper modelMapper;

    public UserLoginBean() {
    }

    @Inject
    public UserLoginBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void init() {
        this.model = new UserLoginBindingModel();
    }

    public UserLoginBindingModel getModel() {
        return this.model;
    }

    public void setModel(UserLoginBindingModel model) {
        this.model = model;
    }

    public void login() throws IOException {
        UserServiceModel userServiceModel = this.userService
                .loginUser(this.modelMapper.map(model, UserServiceModel.class));

        if (userServiceModel == null){
            throw new IllegalArgumentException("Something went wrong!");
        }

        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequest();

        HttpSession session = request.getSession();

        session.setAttribute("username", userServiceModel.getUsername());
        session.setAttribute("id", userServiceModel.getId());

        FacesContext.getCurrentInstance().getExternalContext().redirect("/view/home.jsf");
    }
}
