package com.tdep.tadlab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity(name = "Tool")
@Table(name = "tools")
public class Tool extends PortfolioEntry {

    @Setter
    @Column(name = "tool_name")
    private String toolName;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "project")
    private Project project;

    @OneToOne(
            mappedBy = "tools",
            orphanRemoval = true,
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    @MapsId
    @Column(name = "link")
    private Link link;

    public Tool(String toolName, Project project, Link link) {
        this.toolName = toolName;
        this.project = project;
        this.link = link;
    }

    public Tool() {

    }

    public void setProject(Project project) {
        this.project = project;
        project.addTool(this);
    }

    public void removeProject() {
        this.project.removeTool(this);
        this.project = null;
    }

    public void setLink(Link link) {
        this.link = link;
        link.setTool(this);
    }

    public void removeLink() {
        this.link.removeTool();
        this.link = null;
    }

    @Override
    public boolean equals(Object o) {
        long id = this.getEntryId();
        if (this == o) return true;
        if (!(o instanceof Tool)) return false;
        return id != 0 && id == ((Tool) o).getEntryId();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return  "Tool{" +
                " id=" + this.getEntryId() +
                " name=" + toolName +
                ", project='" + project + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
