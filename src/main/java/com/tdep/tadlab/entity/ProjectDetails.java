package com.tdep.tadlab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Entity(name = "ProjectDetails")
@Table(name = "project_details")
public class ProjectDetails extends PortfolioEntry {

    @Setter
    @Column(name = "description")
    private String description;

    @Setter
    @Column(name = "created")
    private Date created;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Project project;

    public void setProject(Project project) {
        this.project = project;
        project.addDetails(this);
    }

    public void removeProject() {
        this.project.removeDetails();
        this.project = null;
    }

    public ProjectDetails(String description, Date created, Project project) {
        this.description = description;
        this.created = created;
        this.project = project;
    }

    public ProjectDetails() {

    }

    @Override
    public String toString() {
        return  "details{" +
                ", id='" + this.getEntryId() + '\'' +
                ", description='" + description + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
