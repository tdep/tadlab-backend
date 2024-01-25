package com.tdep.tadlab.repository;

import com.tdep.tadlab.dao.JobDao;
import com.tdep.tadlab.model.Job;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JobDaoImpl implements JobDao {

  @Autowired
  private EntityManager entityManager;
  @Override
  public List<Job> getAllJobs() {
    return entityManager.createQuery("SELECT j FROM Job j").getResultList();
  }

  @Override
  public Optional<Job> getJobById(int id) {
    return Optional.ofNullable(entityManager.find(Job.class, id));
  }

  @Override
  public Job save(Job job) { return entityManager.merge(job); }

  @Override
  public void delete(Job job) { entityManager.remove(job); }
}
