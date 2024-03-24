package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.projectDb.Link;
import com.tdep.tadlab.entity.projectDb.Project;
import com.tdep.tadlab.entity.projectDb.ProjectDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ProjectWriteService {

//    Project
    ResponseEntity<Project> createNewProject(Project project);
    ResponseEntity<Project> updateExistingProject(int id, Project project);
    ResponseEntity<Project> addDetailToProject(int projectId, ProjectDetail detail);
    ResponseEntity<Project> addLinkToProject(int projectId, Link link);
    ResponseEntity<Project> addMultipleLinksToProject(int projectId, List<Link> links);
    ResponseEntity<Project> removeDetailFromProject(int projectId, ProjectDetail detail);
    ResponseEntity<Project> removeLinkFromProject(int projectId, Link link);
    ResponseEntity<Project> removeAllLinksFromProject(int projectId);
    ResponseEntity<HttpStatus> deleteProjectById(int projectId);
    ResponseEntity<HttpStatus> deleteAllProjects();

//    Project Detail
    CompletableFuture<ResponseEntity<ProjectDetail>> createNewProjectDetail(int projectId, ProjectDetail detail);
    ResponseEntity<ProjectDetail> updateExistingProjectDetail(int projectId,ProjectDetail detail);
    ResponseEntity<HttpStatus> deleteProjectDetailByProjectId(int projectId);
    ResponseEntity<HttpStatus> deleteProjectDetailByProjectName(String projectName);

//    Link
    ResponseEntity<Link> createNewLink(Link link);
    ResponseEntity<Link> updateExistingLink(int id, Link link);
    ResponseEntity<Link> updateExistingProjectLink(int projectId, Link link);
    ResponseEntity<HttpStatus> deleteLink(int id);
}
