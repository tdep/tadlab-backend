package com.tdep.tadlab.entity.projectDb;

import com.tdep.tadlab.entity.common.BasePortfolioEntryAudit;
import com.tdep.tadlab.entity.common.EntryType;
import jakarta.persistence.*;


@Entity
@Table(name = "project_details")
public class ProjectDetail extends BasePortfolioEntryAudit {

    @Column(name = "description")
    private String description;

    public ProjectDetail(String entryName, EntryType entryType, String description) {
        super.setEntryName(entryName);
        super.setEntryType(entryType);
        this.description = description;
    }

    public ProjectDetail() {

    }

    public String getDescription() { return description; }

    public void setDescription(String description) {this.description = description; }

    @Override
    public String toString() {
        return  "{" +
                ", description='" + description + '\'' +
                '}' +
                super.toString();
    }

}
