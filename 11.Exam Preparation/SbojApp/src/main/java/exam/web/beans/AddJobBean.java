package exam.web.beans;

import exam.domain.models.binding.JobAddBindingModel;
import exam.domain.models.service.JobServiceModel;
import exam.domain.models.service.UserServiceModel;
import exam.domain.models.view.JobHomeViewModel;
import exam.service.JobService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class AddJobBean extends BaseWebBean {
    private JobService jobService;
    private JobAddBindingModel jobAddBindingModel;

    public AddJobBean() {
    }

    @Inject
    public AddJobBean(ModelMapper modelMapper, JobService jobService) {
        super(modelMapper);
        this.jobService = jobService;
        this.init();


    }

    private void init() {
        this.jobAddBindingModel = new JobAddBindingModel();

    }

    public JobAddBindingModel getJobAddBindingModel() {
        return jobAddBindingModel;
    }

    public void setJobAddBindingModel(JobAddBindingModel jobAddBindingModel) {
        this.jobAddBindingModel = jobAddBindingModel;
    }

    public void register() throws IOException {

        JobServiceModel jobServiceModel = this.modelMapper.map(jobAddBindingModel, JobServiceModel.class);

        if (!this.jobService.addJob(jobServiceModel)) {
            throw new IllegalArgumentException("The job can not be persist - check if all fields are entered or check into database if job already exist!");
        }

        redirect("/home");
    }
}
