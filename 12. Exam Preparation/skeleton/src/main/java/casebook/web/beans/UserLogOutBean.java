package casebook.web.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class UserLogOutBean {

    public void logout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "");
    }
}

