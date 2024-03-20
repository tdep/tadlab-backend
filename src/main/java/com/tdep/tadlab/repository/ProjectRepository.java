package com.tdep.tadlab.repository;

import com.tdep.tadlab.entity.projectDb.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
