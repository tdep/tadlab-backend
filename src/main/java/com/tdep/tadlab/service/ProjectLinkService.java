package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.ProjectLink;

import java.util.List;

public interface ProjectLinkService {

    ProjectLink saveProjectLink(ProjectLink projectLink);

    List<ProjectLink> fetchProjectLinkList();

    ProjectLink updateProjectLink(ProjectLink projectLink, int projectLinkId);

    void deleteProjectLinkById(int projectLinkId);
}
