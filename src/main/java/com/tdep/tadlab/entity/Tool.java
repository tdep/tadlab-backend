package com.tdep.tadlab.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Tool extends PortfolioEntry {
    @ManyToMany(mappedBy = "tools")
    private Set<Project> projects = new HashSet<>();

    public Tool(String name, EntryType entryType) {
        super(name, entryType);
    }

    public Tool() {
    }

    public void addProject(Project project) {
        boolean added = projects.add(project);
        if (added) {
            project.getTools().add(this);
        }
    }

    public void removeProject(Project project) {
        boolean removed = projects.remove(project);
        if (removed) {
            project.getTools().remove(this);
        }
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

}
