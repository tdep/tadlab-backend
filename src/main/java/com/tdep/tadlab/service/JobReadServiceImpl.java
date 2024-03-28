package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.projectDb.Job;
import com.tdep.tadlab.repository.JobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobReadServiceImpl implements JobReadService {

    @Autowired
    private JobRepository jobRepository;

    Logger logger = LoggerFactory.getLogger(ProjectWriteServiceImpl.class);

    public ResponseEntity<List<Job>> findAllJobs() {
        return null;
    }

    public ResponseEntity<Job> findJobById(int id) {
        return null;
    }

    public ResponseEntity<Job> findJobByName(String name) {
        return null;
    }
}
