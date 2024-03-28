package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.projectDb.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface JobWriteService {

    ResponseEntity<Job> createNewJob(Job job);
    ResponseEntity<Job> updateExistingJob(int id, Job job);
    ResponseEntity<HttpStatus> deleteJobById(int id);
    ResponseEntity<HttpStatus> deleteAllJobs();
}
