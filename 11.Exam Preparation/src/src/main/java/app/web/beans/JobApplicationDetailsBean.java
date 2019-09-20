package app.web.beans;

import app.domain.models.service.JobServiceModel;
import app.service.JobService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class JobApplicationDetailsBean {
    private JobService jobService;

    public JobApplicationDetailsBean() {
    }

    @Inject
    public JobApplicationDetailsBean(JobService jobService) {
        this.jobService = jobService;
    }

    public JobServiceModel getJob(String id){
        return this.jobService.getJobById(id);
    }

}
