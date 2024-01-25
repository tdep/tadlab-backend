package com.tdep.tadlab.controller;

import com.tdep.tadlab.dao.JobDao;
import com.tdep.tadlab.model.Job;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class JobController {

  @Autowired
  private JobDao jobDao;

  @GetMapping("/jobs")
  public List<Job> getAllJobs() {
    System.out.println("o0g8ehrogiengkle");
    return jobDao.getAllJobs(); }

  @GetMapping("/jobs/{id}")
  public ResponseEntity<Job> getJobById(@PathVariable int id) {
    Optional<Job> job = jobDao.getJobById(id);
    return job.map(ResponseEntity::ok)
        .orElseGet(() ->
            ResponseEntity.notFound()
                .build());
  }

  @PostMapping("/jobs/new")
  public ResponseEntity<Job> createJob(@RequestBody Job job) {
    Job savedJob = jobDao.save(job);
    return ResponseEntity.created(URI.create("/jobs/" + savedJob.getId())).body(savedJob);
  }

  @PutMapping("/jobs/{id}")
  public ResponseEntity<Job> updateJob(@PathVariable int id, @RequestBody Job job) {
    Optional<Job> existingJob = jobDao.getJobById(id);
    if (existingJob.isPresent()) {
      job.setId(id);
      Job savedJob = jobDao.save(job);
      return ResponseEntity.ok(savedJob);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/jobs/{id}")
  public ResponseEntity<Void> deleteJob(@PathVariable int id) {
    Optional<Job> job = jobDao.getJobById(id);
    if (job.isPresent()) {
      jobDao.delete(job.get());
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
