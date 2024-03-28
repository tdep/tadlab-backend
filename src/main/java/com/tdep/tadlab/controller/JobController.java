package com.tdep.tadlab.controller;


import com.tdep.tadlab.entity.projectDb.Job;
import com.tdep.tadlab.service.JobReadService;
import com.tdep.tadlab.service.JobWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "PostmanRuntime/7.37.0")
@RestController
@RequestMapping("/api/v1")
public class JobController {

    @Autowired
    private JobWriteService jobWriteService;

    @Autowired
    private JobReadService jobReadService;

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getAllJobs() { return jobReadService.findAllJobs(); }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable("id") int id) {
        return jobReadService.findJobById(id);
    }

    @PostMapping("/jobs")
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        return jobWriteService.createNewJob(job);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable("id") int id, @RequestBody Job job) {
        return jobWriteService.updateExistingJob(id, job);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<HttpStatus> deleteJob(@PathVariable("id") int id) {
        return jobWriteService.deleteJobById(id);
    }

    @DeleteMapping("/jobs")
    public ResponseEntity<HttpStatus> deleteAllJobs() { return jobWriteService.deleteAllJobs(); }
}
