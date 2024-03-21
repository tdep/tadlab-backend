package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.projectDb.Link;
import com.tdep.tadlab.entity.projectDb.Project;
import com.tdep.tadlab.entity.projectDb.ProjectDetail;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectReadService {

//    Project
    ResponseEntity<List<Project>> findAllProjects();
    ResponseEntity<Project> findProjectById(int id);
    ResponseEntity<Project> findProjectByName(String name);
    ResponseEntity<List<Project>> findProjectsByLinkType(String linkType);
    ResponseEntity<List<Project>> findProjectsByDate(String date);

//    Project Details
    ResponseEntity<List<ProjectDetail>> findAllProjectDetails();
    ResponseEntity<ProjectDetail> findDetailById(int id);
    ResponseEntity<ProjectDetail> findDetailByProjectName(String projectName);
    ResponseEntity<ProjectDetail> findDetailByProjectId(int projectId);

//    Link
    ResponseEntity<List<Link>> findAllLinks();
    ResponseEntity<Link> findLinkById(int id);
    ResponseEntity<Link> findLinkByType(String type);
    ResponseEntity<List<Link>> findLinksByProjectName(String projectName);
    ResponseEntity<List<Link>> findLinksByProjectId(int projectId);

}
