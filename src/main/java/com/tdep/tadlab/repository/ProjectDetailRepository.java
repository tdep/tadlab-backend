package com.tdep.tadlab.repository;

import com.tdep.tadlab.entity.projectDb.ProjectDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDetailRepository extends JpaRepository<ProjectDetail, Integer> {

    @Query("SELECT d FROM ProjectDetail d WHERE d.project = :projectId")
    ProjectDetail findProjectDetailByProjectId(@Param("projectId") int projectId);
}
