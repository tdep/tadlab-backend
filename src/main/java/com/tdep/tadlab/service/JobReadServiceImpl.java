package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.projectDb.Job;
import com.tdep.tadlab.repository.JobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobReadServiceImpl implements JobReadService {

    @Autowired
    private JobRepository jobRepository;

    Logger logger = LoggerFactory.getLogger(ProjectWriteServiceImpl.class);

    public ResponseEntity<List<Job>> findAllJobs() {
        try {
            List<Job> jobs = new ArrayList<>(
                    jobRepository.findAll());
            if (jobs.isEmpty()) {
                logger.info("No Jobs found.");
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(jobs, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(String.format("Could not find Jobs because of exception: %s", e.getMessage()));
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Job> findJobById(int id) {
        Optional<Job> jobData = jobRepository.findById(id);

        return jobData.map(
                job -> new ResponseEntity<>(
                        job, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(
                        HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Job> findJobByName(String name) {
        return null;
    }
}
