package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.projectDb.ProjectDetail;
import com.tdep.tadlab.repository.ProjectDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// TODO: Create Logger to replace sysout
@Service
public class ProjectDetailServiceImpl implements ProjectDetailService {

    @Autowired
    private ProjectDetailRepository projectDetailRepository;

    public ResponseEntity<List<ProjectDetail>> getAllDetails() {
        try {
            List<ProjectDetail> details = new ArrayList<>(
                    projectDetailRepository.findAll());
            if (details.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(details, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ProjectDetail> getDetailById(int id) {
        Optional<ProjectDetail> detailData = projectDetailRepository.findById(id);

        return detailData.map(
                detail -> new ResponseEntity<>(
                        detail, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(
                        HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<ProjectDetail> createDetail(ProjectDetail detail) {
        try {
            ProjectDetail _detail = projectDetailRepository
                    .save(new ProjectDetail(
                            detail.getEntryName(),
                            detail.getEntryType(),
                            detail.getProject(),
                            detail.getDescription()
                    ));
            System.out.println(detail);
            return new ResponseEntity<>(_detail, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ProjectDetail> updateDetail(int id, ProjectDetail detail) {
        Optional<ProjectDetail> detailData = projectDetailRepository.findById(id);

        if (detailData.isPresent()) {
            System.out.println(detailData.get());
            ProjectDetail _detail = detailData.get();
            _detail.setEntryName(detail.getEntryName());
            _detail.setEntryType(detail.getEntryType());
            _detail.setProject(detail.getProject());
            _detail.setDescription(detail.getDescription());
            return new ResponseEntity<>(projectDetailRepository.save(_detail), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<HttpStatus> deleteDetail(int id) {
        try {
            projectDetailRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteAllDetails() {
        try {
            projectDetailRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
