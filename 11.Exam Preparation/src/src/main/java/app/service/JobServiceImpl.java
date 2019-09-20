package app.service;

import app.domain.entities.Job;
import app.domain.models.service.JobServiceModel;
import app.repository.JobRepository;
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
    public boolean registerJob(JobServiceModel jobServiceModel) {
        Job job = this.modelMapper.map(jobServiceModel, Job.class);

        if (this.jobRepository.save(job) == null) {
            return false;
        }

        return true;
    }

    @Override
    public List<JobServiceModel> findAll() {
        List<JobServiceModel> jobs = this.jobRepository
                .findAll()
                .stream()
                .map(job -> this.modelMapper.map(job,JobServiceModel.class))
                .collect(Collectors.toList());
        return jobs;
    }

    @Override
    public JobServiceModel getJobById(String id) {
        Job job = this.jobRepository.findById(id);

        return this.modelMapper.map(job, JobServiceModel.class);
    }

    @Override
    public void delete(String id) {
        this.jobRepository.delete(id);
    }
}
