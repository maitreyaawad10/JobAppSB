package com.example.crudApi.job.impl;

import com.example.crudApi.job.Job;
import com.example.crudApi.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public Job getJobById(Long id) {
        for (Job job: jobs) {
            if (job.getId().equals(id))
                return job;
        }

        return null;
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        for (Job job: jobs) {
            if (job.getId().equals(id)) {
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean deleteJobById(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()) {
            Job job = iterator.next();
            if (job.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }
}
