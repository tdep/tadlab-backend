package com.tdep.tadlab.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="tools")
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(mappedBy = "project_tools")
    private Set<Project> projects;
    private String name;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Set<Project> getProject() { return projects; }

    public void setProject(Set<Project> projects) { this.projects = projects; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
