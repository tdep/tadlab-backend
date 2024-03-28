package com.tdep.tadlab.service;


import com.tdep.tadlab.entity.projectDb.Job;
import com.tdep.tadlab.repository.JobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class JobWriteServiceImpl implements JobWriteService {

    @Autowired
    JobRepository jobRepository;

    Logger logger = LoggerFactory.getLogger(JobWriteServiceImpl.class);

    public ResponseEntity<Job> createNewJob(Job job) {
        return null;
    }

    public ResponseEntity<Job> updateExistingJob(int id, Job job) {
        return null;
    }

    public ResponseEntity<HttpStatus> deleteJobById(int id) {
        return null;
    }

    public ResponseEntity<HttpStatus> deleteAllJobs() {
        return null;
    }
}
