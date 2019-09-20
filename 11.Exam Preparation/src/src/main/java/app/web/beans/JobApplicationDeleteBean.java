package app.web.beans;

import app.domain.models.service.JobServiceModel;
import app.service.JobService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Named
@RequestScoped
public class JobApplicationDeleteBean {

    private JobService jobService;

    public JobApplicationDeleteBean() {
    }

    @Inject
    public JobApplicationDeleteBean(JobService jobService) {
        this.jobService = jobService;
    }

    public JobServiceModel getJob(String id){
        return this.jobService.getJobById(id);
    }

    public void delete() throws IOException {
        String id = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id");
        this.jobService.delete(id);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/view/home.jsf");
    }
}
