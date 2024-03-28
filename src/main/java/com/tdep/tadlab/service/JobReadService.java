package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.projectDb.Job;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobReadService {

    ResponseEntity<List<Job>> findAllJobs();
    ResponseEntity<Job> findJobById(int id);
    ResponseEntity<Job> findJobByName(String name);

}
