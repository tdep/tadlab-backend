package com.tdep.tadlab.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "ProjectDetails")
@Table(name = "project_details")
public class ProjectDetails extends PortfolioEntry {

    @Setter
    @Getter
    @Column(name = "description")
    private String description;

    @Setter
    @Getter
    @Column(name = "created")
    private Date created;

    @OneToOne
    private Project project;

    public void setProject(Project project) {
        this.project = project;
        project.addDetails(this);
    }

    public void removeProject() {
        this.project.removeDetails();
        this.project = null;
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
