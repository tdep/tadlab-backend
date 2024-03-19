package com.tdep.tadlab.entity.projectDb;

import com.tdep.tadlab.entity.common.BasePortfolioEntryAudit;
import com.tdep.tadlab.entity.common.EntryType;
import jakarta.persistence.*;


@Entity
@Table(name = "project_details")
public class ProjectDetail extends BasePortfolioEntryAudit {

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Project project;

    @Column(name = "description")
    private String description;

    public ProjectDetail(String entryName, EntryType entryType, Project project, String description) {
        super.setEntryName(entryName);
        super.setEntryType(entryType);
        this.project = project;
        this.description = description;
    }

    public ProjectDetail() {

    }

    private Project getProject() { return project; }

    private void setProject(Project project) { this.project = project; }

    private String getDescription() { return description; }

    private void setDescription(String description) {this.description = description; }

    @Override
    public String toString() {
        return  "{" +
                ", project='" + project.toString() + '\'' +
                ", description='" + description + '\'' +
                '}' +
                super.toString();
    }
}
