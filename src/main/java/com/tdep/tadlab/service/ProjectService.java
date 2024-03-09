package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.Project;

import java.util.List;
import java.util.Set;

public interface ProjectService {

    Project saveProject(Project project);

    List<Project> fetchProjectList();

    Project updateProject(Project project, int projectId);

    void deleteProjectById(int projectId);
}
