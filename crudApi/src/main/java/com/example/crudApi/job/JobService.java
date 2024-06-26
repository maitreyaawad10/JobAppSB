package com.example.crudApi.job;

import java.util.List;

public interface JobService {
    void createJob(Job job);

    List<Job> findAll();

    Job getJobById(Long id);

    boolean updateJobById(Long id, Job updatedJob);

    boolean deleteJobById(Long id);
}
