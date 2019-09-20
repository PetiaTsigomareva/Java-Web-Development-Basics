package exam.service;

import exam.domain.entities.Job;
import exam.domain.models.service.JobServiceModel;
import exam.repository.JobRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    @Inject
    public JobServiceImpl(JobRepository jobRepository, ModelMapper modelMapper) {
        this.jobRepository = jobRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean addJob(JobServiceModel jobServiceModel) {
        boolean result = true;
        Job job = this.modelMapper.map(jobServiceModel, Job.class);
        if (this.jobRepository.save(job) == null) {
            result = false;
        }
        return result;
    }

    @Override
    public void deleteJob(String id) {

    }

    @Override
    public JobServiceModel findByID(String id) {
        return null;
    }

    @Override
    public List<JobServiceModel> getAllJobs() {
        List<JobServiceModel> jobs = this.jobRepository.findAll().stream().map(j -> this.modelMapper.map(j, JobServiceModel.class)).collect(Collectors.toList());
        return jobs;
    }
}
