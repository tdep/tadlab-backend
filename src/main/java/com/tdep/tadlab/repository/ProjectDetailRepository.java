package com.tdep.tadlab.repository;

import com.tdep.tadlab.entity.projectDb.ProjectDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDetailRepository extends JpaRepository<ProjectDetail, Integer> {

}
