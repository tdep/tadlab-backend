package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.Project;
import com.tdep.tadlab.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> fetchProjectList() {
        return (List<Project>) projectRepository.findAll();
    }

    @Override
    public Project updateProject(Project project, int projectId) {
        Project projectDB = null;
        if (projectRepository.findById(projectId).isPresent()) {
            projectDB = projectRepository.findById(projectId).get();

            if (Objects.nonNull(project.getTitle())
            && !"".equalsIgnoreCase(
                    project.getTitle())) {
                projectDB.setTitle(
                        project.getTitle());
            }

            if (Objects.nonNull(project.getDescription())
            && !"".equalsIgnoreCase(
                    project.getDescription())) {
                projectDB.setDescription(
                        project.getDescription());
            }

            if (Objects.nonNull(project.getImageUrl())
            && !"".equalsIgnoreCase(
                    project.getImageUrl())) {
                projectDB.setImageUrl(
                        project.getImageUrl());
            }
        }
        assert projectDB != null;
        return projectRepository.save(projectDB);
    }

    @Override
    public void deleteProjectById(int projectId) {
        projectRepository.deleteById(projectId);
    }
}
