package com.tdep.tadlab.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project extends PortfolioEntry {

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "project_tools",
            joinColumns = { @JoinColumn(name = "project_id") },
            inverseJoinColumns = { @JoinColumn(name = "tool_id") },
            uniqueConstraints = {
                    @UniqueConstraint(
                            columnNames = { "project_id", "tool_id" }
                    )
            }
    )
    private Set<Tool> tools = new HashSet<>();

    public Project(String name, EntryType entryType) {
        super(name, entryType);
    }
    public Project() {
    }

    public Project(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addTool(Tool tool) {
        boolean added = tools.add(tool);
        if(added) {
            tool.getProjects().add(this);
        }
    }

    public void removeTool(Tool tool) {
        boolean removed = tools.remove(tool);
        if(removed) {
            tool.getProjects().remove(this);
        }
    }

    public Set<Tool> getTools() {
        return tools;
    }

    public void setTools(Set<Tool> tools) {
        this.tools = tools;
    }

}

