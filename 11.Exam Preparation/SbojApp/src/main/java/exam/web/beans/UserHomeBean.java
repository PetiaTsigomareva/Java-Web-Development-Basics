package exam.web.beans;

import exam.domain.models.view.JobHomeViewModel;
import exam.service.JobService;
import exam.service.UserService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class UserHomeBean extends BaseWebBean {

    private List<JobHomeViewModel> jobs;

    private JobService jobService;


    public UserHomeBean() {
        super();
    }

    public UserHomeBean(JobService jobService, ModelMapper modelMapper) {
        super(modelMapper);
        this.jobService = jobService;

        this.init();

    }


    public void init() {
        this.jobs = this.jobService.getAllJobs().stream().map(j -> this.modelMapper.map(j, JobHomeViewModel.class)).collect(Collectors.toList());
    }

    public List<JobHomeViewModel> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobHomeViewModel> jobs) {
        this.jobs = jobs;
    }

    public void details(String id) throws IOException {
        redirect("/job-details");
    }

    void delete(String id) throws IOException {
        redirect("/delete-job");
    }
}
