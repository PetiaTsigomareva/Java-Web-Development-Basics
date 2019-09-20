package exam.service;

import exam.domain.models.service.JobServiceModel;
import exam.domain.models.service.UserServiceModel;

import java.util.List;

public interface JobService {

    boolean addJob(JobServiceModel jobServiceModel);

    void deleteJob(String id);

    JobServiceModel findByID(String id);

    List<JobServiceModel> getAllJobs();

}
