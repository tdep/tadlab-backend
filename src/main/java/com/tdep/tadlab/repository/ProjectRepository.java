package com.tdep.tadlab.repository;

import com.tdep.tadlab.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findProjectsByName(String name);

    Optional<Project> findByName(String name);

}
