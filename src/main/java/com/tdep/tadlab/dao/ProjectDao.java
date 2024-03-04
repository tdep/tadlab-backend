package com.tdep.tadlab.dao;

import com.tdep.tadlab.model.Project;
import com.tdep.tadlab.model.Tool;

import java.util.List;
import java.util.Optional;

public interface ProjectDao {

    List<Project> getAllProjects();
    Optional<Project> getProjectById(int id);
    Optional<List<Project>> getProjectsByTool(Tool tool);
    Project save(Project project);
    void delete(Project project);
}
