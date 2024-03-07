package com.tdep.tadlab.repository;

import com.tdep.tadlab.entity.ProjectLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectLinkRepository extends JpaRepository<ProjectLink, Integer> {

}
