package com.tdep.tadlab.service;


import com.tdep.tadlab.entity.projectDb.Job;
import com.tdep.tadlab.repository.JobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobWriteServiceImpl implements JobWriteService {

    @Autowired
    JobRepository jobRepository;

    Logger logger = LoggerFactory.getLogger(JobWriteServiceImpl.class);

    public ResponseEntity<Job> createNewJob(Job job) {
        try {

            Job _job = jobRepository
                    .save(new Job(
                            job.getEntryName(),
                            job.getEntryType(),
                            job.getCreatedBy(),
                            job.getCreatedAt(),
                            job.getName(),
                            job.getStartDate(),
                            job.getEndDate(),
                            job.getJobDetail()
                    ));

            logger.info(String.format("Job: %s created successfully!", _job.getId()));
            return new ResponseEntity<>(_job, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(String.format("Couldn't create Job with error: %s", e.getMessage()));
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Job> updateExistingJob(int id, Job job) {
        Optional<Job> jobData = jobRepository.findById(id);

        if(jobData.isPresent()) {
            Job _job = jobData.get();
            _job.setEntryName(job.getEntryName());
            _job.setEntryType(job.getEntryType());
            _job.setCreatedBy(job.getCreatedBy());
            _job.setUpdatedBy(job.getUpdatedBy());
            _job.setUpdatedAt(job.getUpdatedAt());
            _job.setName(job.getName());
            _job.setStartDate(job.getStartDate());
            _job.setEndDate(job.getEndDate());
            _job.setJobDetail(job.getJobDetail());
            logger.info("Job updated successfully!");
            return new ResponseEntity<>(jobRepository.save(_job), HttpStatus.OK);
        } else {
            logger.error("Job does not exist");
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<HttpStatus> deleteJobById(int id) {
        try {
            jobRepository.deleteById(id);
            logger.info("Job deleted successfully!");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error(String.format("Unable to delete this Job because: %s", e.getMessage()));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteAllJobs() {
        try {
            jobRepository.deleteAll();
            logger.info("All Jobs deleted successfully!");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error(String.format("Unable to delete all Jobs because: %s", e.getMessage()));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
