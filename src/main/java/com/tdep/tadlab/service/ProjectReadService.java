package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.projectDb.Link;
import com.tdep.tadlab.entity.projectDb.Project;
import com.tdep.tadlab.entity.projectDb.ProjectDetail;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectReadService {

    ResponseEntity<List<Project>> getAllProjects();
    ResponseEntity<List<ProjectDetail>> getAllDetails();
    ResponseEntity<List<Link>> getAllLinks();

    ResponseEntity<Project> getProjectById(int id);
    ResponseEntity<ProjectDetail> getDetailById(int id);
    ResponseEntity<Link> getLinkById(int id);
}
