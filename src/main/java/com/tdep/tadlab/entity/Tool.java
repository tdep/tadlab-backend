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
    @NaturalId
    private String toolName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
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
    public String toString() {
        return  "Tool{" +
                " id=" + this.getEntryId() +
                " name=" + toolName +
                ", project='" + project + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
