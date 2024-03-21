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
public class ProjectReadServiceImpl implements ProjectReadService {

    @Autowired
    private ProjectRepository projectRepository;
    private ProjectDetailRepository projectDetailRepository;
    private LinkRepository linkRepository;

//    Project

    public ResponseEntity<List<Project>> findAllProjects() {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Project> findProjectById(int id) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Project> findProjectByName(String name) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<List<Project>> findProjectsByLinkType(String linkType) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<List<Project>> findProjectsByDate(String date) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

//    Project Detail

    public ResponseEntity<List<ProjectDetail>> findAllProjectDetails() {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<ProjectDetail> findDetailById(int id) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<ProjectDetail> findDetailByProjectName(String projectName) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<ProjectDetail> findDetailByProjectId(int projectId) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

//    Link

    public ResponseEntity<List<Link>> findAllLinks() {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Link> findLinkById(int id) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<Link> findLinkByType(String type) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<List<Link>> findLinksByProjectName(String projectName) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntity<List<Link>> findLinksByProjectId(int projectId) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }
}
