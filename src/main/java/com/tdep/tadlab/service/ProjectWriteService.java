package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.projectDb.Link;
import com.tdep.tadlab.entity.projectDb.Project;
import com.tdep.tadlab.entity.projectDb.ProjectDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectWriteService {

//    Project
    ResponseEntity<Project> createNewProject(Project project);
    ResponseEntity<Project> updateExistingProject(int id, Project project);
    ResponseEntity<Project> addDetailToProject(int id, ProjectDetail detail);
    ResponseEntity<Project> addLinkToProject(int id, Link link);
    ResponseEntity<Project> addMultipleLinksToProject(int id, List<Link> links);
    ResponseEntity<Project> removeDetailFromProject(int id, ProjectDetail detail);
    ResponseEntity<Project> removeLinkFromProject(int id, Link link);
    ResponseEntity<Project> removeAllLinksFromProject(int id);
    ResponseEntity<HttpStatus> deleteProjectById(int id);
    ResponseEntity<HttpStatus> deleteAllProjects();

//    Project Detail
    ResponseEntity<ProjectDetail> createNewProjectDetail(int projectId, ProjectDetail detail);
    ResponseEntity<ProjectDetail> updateExistingProjectDetail(int projectId,ProjectDetail detail);
    ResponseEntity<HttpStatus> deleteProjectDetailByProjectId(int projectId);
    ResponseEntity<HttpStatus> deleteProjectDetailByProjectName(String projectName);

//    Link
    ResponseEntity<Link> createNewLink(Link link);
    ResponseEntity<Link> updateExistingLink(int id, Link link);
    ResponseEntity<Link> updateExistingProjectLink(int projectId, Link link);
    ResponseEntity<HttpStatus> deleteLink(int id);
}
