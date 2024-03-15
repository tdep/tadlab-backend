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

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

}
