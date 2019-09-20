package app.web.beans;

import app.domain.models.service.JobServiceModel;
import app.service.JobService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class JobApplicationListBean {
    private JobService jobService;

    private List<JobServiceModel> jobServiceModels;

    public JobApplicationListBean() {
    }

    @Inject
    public JobApplicationListBean(JobService jobService) {
        this.jobService = jobService;
    }

    @PostConstruct
    public void init() {
        this.setJobServiceModels(this.jobService.findAll());
        this.getJobServiceModels()
                .forEach(jobServiceModel -> jobServiceModel.setSector(jobServiceModel.getSector()
                        .toLowerCase()));
    }

    public List<JobServiceModel> getJobServiceModels() {
        return this.jobServiceModels;
    }

    public void setJobServiceModels(List<JobServiceModel> jobServiceModels) {
        this.jobServiceModels = jobServiceModels;
    }
}
