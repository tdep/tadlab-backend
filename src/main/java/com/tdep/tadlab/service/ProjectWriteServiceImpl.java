package com.tdep.tadlab.service;


import com.tdep.tadlab.entity.projectDb.Link;
import com.tdep.tadlab.entity.projectDb.Project;
import com.tdep.tadlab.entity.projectDb.ProjectDetail;
import com.tdep.tadlab.repository.LinkRepository;
import com.tdep.tadlab.repository.ProjectDetailRepository;
import com.tdep.tadlab.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO: Create Logger to replace sysout
@Service
public class ProjectWriteServiceImpl implements ProjectWriteService {

    @Autowired
    private ProjectRepository projectRepository;
    private ProjectDetailRepository projectDetailRepository;
    private LinkRepository linkRepository;

//    Project

    public ResponseEntity<Project> createNewProject(Project project) {
        return new ResponseEntity<>(project, HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Project> updateExistingProject(int id, Project project) {
        return new ResponseEntity<>(project, HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Project> addDetailToProject(int projectId, ProjectDetail detail) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Project> addLinkToProject(int projectId, Link link) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Project> addMultipleLinksToProject(int projectId, List<Link> links) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Project> removeDetailFromProject(int projectId, ProjectDetail detail) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Project> removeLinkFromProject(int projectId, Link link) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Project> removeAllLinksFromProject(int projectId) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<HttpStatus> deleteProjectById(int projectId) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<HttpStatus> deleteAllProjects() {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

//    Project Detail

    public ResponseEntity<ProjectDetail> createNewProjectDetail(int projectId, ProjectDetail detail) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<ProjectDetail> updateExistingProjectDetail(int projectId, ProjectDetail detail) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<HttpStatus> deleteProjectDetailByProjectId(int projectId) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<HttpStatus> deleteProjectDetailByProjectName(String projectName) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

//    Link

    public ResponseEntity<Link> createNewLink(Link link) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Link> updateExistingLink(int linkId, Link link) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Link> updateExistingProjectLink(int projectId, Link link) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<HttpStatus> deleteLink(int linkId) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }
}
