package com.tdep.tadlab.dao;

import com.tdep.tadlab.model.Job;
import java.util.List;
import java.util.Optional;

public interface JobDao {

  List<Job> getAllJobs();

  Optional<Job> getJobById(int id);

  Job save(Job job);

  void delete(Job job);
}
