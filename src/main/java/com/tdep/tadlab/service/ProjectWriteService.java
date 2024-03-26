package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.projectDb.Link;
import com.tdep.tadlab.entity.projectDb.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectWriteService {

//    Project
    ResponseEntity<Project> createNewProject(Project project);
    ResponseEntity<Project> updateExistingProject(int id, Project project);
    ResponseEntity<Project> addLinkToProject(int projectId, Link link);
    ResponseEntity<Project> addMultipleLinksToProject(int projectId, List<Link> links);
    ResponseEntity<Project> removeLinkFromProject(int projectId, String name);
    ResponseEntity<Project> removeAllLinksFromProject(int projectId);
    ResponseEntity<HttpStatus> deleteProjectById(int projectId);
    ResponseEntity<HttpStatus> deleteAllProjects();

}
