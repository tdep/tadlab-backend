package com.tdep.tadlab.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="tools")
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH })
    @JoinTable(
            name = "project_tools",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "tool_id"))
    private Set<Project> projects;
    private String name;

    public Tool() {
    }

    public Tool(String name) {
        this.name = name;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Set<Project> getProject() { return projects; }
    public void setProject(Set<Project> projects) { this.projects = projects; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Tool [name=" + name + ", id=" + id + "]";
    }
}
