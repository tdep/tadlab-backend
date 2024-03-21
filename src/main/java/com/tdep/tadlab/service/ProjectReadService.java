package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.projectDb.Link;
import com.tdep.tadlab.entity.projectDb.Project;
import com.tdep.tadlab.entity.projectDb.ProjectDetail;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectReadService {

//    Project
    ResponseEntity<List<Project>> getAllProjects();
    ResponseEntity<Project> getProjectById(int id);
    ResponseEntity<Project> findProjectByName(String name);
    ResponseEntity<Project> findProjectByLink(String linkName);
    ResponseEntity<Project> findProjectByDate(String date);

//    Project Details
    ResponseEntity<List<ProjectDetail>> getAllDetails();
    ResponseEntity<ProjectDetail> getDetailById(int id);
    ResponseEntity<ProjectDetail> findDetailByProjectName(String projectName);
    ResponseEntity<ProjectDetail> findDetailByProjectId(int projectId);

//    Link
    ResponseEntity<List<Link>> getAllLinks();
    ResponseEntity<Link> getLinkById(int id);
    ResponseEntity<Link> findLinkByType(String type);
    ResponseEntity<Link> findLinkByProjectName(String projectName);
    ResponseEntity<Link> findLinkByProjectId(int projectId);

}
