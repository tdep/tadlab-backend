package com.tdep.tadlab.entity.projectDb;

import com.tdep.tadlab.entity.common.BasePortfolioEntryAudit;
import com.tdep.tadlab.entity.common.EntryType;
import jakarta.persistence.*;


@Entity
@Table(name = "project_details")
public class ProjectDetail extends BasePortfolioEntryAudit {

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "project", nullable = true)
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

    public Project getProject() { return project; }

    public void setProject(Project project) { this.project = project; }

    public String getDescription() { return description; }

    public void setDescription(String description) {this.description = description; }

    @Override
    public String toString() {
        return  "{" +
                ", project='" + project + '\'' +
                ", description='" + description + '\'' +
                '}' +
                super.toString();
    }
}
