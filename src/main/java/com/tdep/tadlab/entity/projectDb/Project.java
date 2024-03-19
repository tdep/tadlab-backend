package com.tdep.tadlab.entity.projectDb;

import com.tdep.tadlab.entity.common.BasePortfolioEntryAudit;
import com.tdep.tadlab.entity.common.EntryType;
import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project extends BasePortfolioEntryAudit {

    @Column(name = "title")
    private String title;

    @OneToOne(
            mappedBy = "project",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private ProjectDetail detail;

    public Project(String entryName, EntryType entryType, String title, ProjectDetail detail) {
        super.setEntryName(entryName);
        super.setEntryType(entryType);
        this.title = title;
        this.detail = detail;
    }

    public Project() {

    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public ProjectDetail getDetail() { return detail; }

    public void setDetail(ProjectDetail detail) { this.detail = detail; }

    @Override
    public String toString() {
        return  "{" +
                ", title='" + title + '\'' +
                ", details ='" + detail.toString() + '\'' +
                '}' +
                super.toString();
    }
}
