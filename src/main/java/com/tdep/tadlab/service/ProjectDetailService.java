package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.projectDb.ProjectDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectDetailService {

    ResponseEntity<List<ProjectDetail>> getAllDetails();

    ResponseEntity<ProjectDetail> getDetailById(int id);

    ResponseEntity<ProjectDetail> createDetail(ProjectDetail detail);

    ResponseEntity<ProjectDetail> updateDetail(int id, ProjectDetail detail);

    ResponseEntity<HttpStatus> deleteDetail(int id);

    ResponseEntity<HttpStatus> deleteAllDetails();
}
