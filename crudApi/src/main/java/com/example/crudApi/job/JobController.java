package com.example.crudApi.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // CREATE A JOB
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job created successfully.", HttpStatus.CREATED);
    }

    // GET ALL JOBS
    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        List<Job> jobs = jobService.findAll();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    // GET JOB BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if (job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // UPDATE JOB BY ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job updatedJob) {
        boolean updated = jobService.updateJobById(id, updatedJob);
        if (updated)
            return new ResponseEntity<>("Job updated successfully.", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE JOB BY ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean deleted = jobService.deleteJobById(id);
        if (deleted)
            return new ResponseEntity<>("Job deleted successfully.", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
