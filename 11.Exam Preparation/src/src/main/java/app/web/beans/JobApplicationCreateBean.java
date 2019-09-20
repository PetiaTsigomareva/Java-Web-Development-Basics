package app.web.beans;

import app.domain.models.binding.JobApplicationCreateBindingModel;
import app.domain.models.service.JobServiceModel;
import app.service.JobService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class JobApplicationCreateBean {
    private JobApplicationCreateBindingModel model;

    private JobService jobService;
    private ModelMapper modelMapper;

    public JobApplicationCreateBean() {
    }

    @Inject
    public JobApplicationCreateBean(JobService jobService, ModelMapper modelMapper) {
        this.jobService = jobService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void init(){
        this.model = new JobApplicationCreateBindingModel();
    }

    public JobApplicationCreateBindingModel getModel() {
        return this.model;
    }

    public void setModel(JobApplicationCreateBindingModel model) {
        this.model = model;
    }

    public void addJob() throws IOException {

        if (!this.jobService.registerJob(this.modelMapper.map(model, JobServiceModel.class))){
            throw new IllegalArgumentException("Something went wrong");
        }

        FacesContext.getCurrentInstance().getExternalContext().redirect("/view/home.jsf");
    }
}
