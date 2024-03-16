package com.tdep.tadlab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "projects")
@PrimaryKeyJoinColumn(referencedColumnName = "entry_id")

public class Project extends PortfolioEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    private long projectId;

    @Setter
    @Column(name = "project_name")
    private String projectName;

    @Setter
    @Column(name = "project_description")
    private String description;

    public Project(String projectName, String description, EntryType entryType) {
        super(entryType);
        this.projectName = projectName;
        this.description = description;
    }
    public Project() {
        super();
    }

    @Override
    public String toString() {
        return  "Tool{" +
                ", name='" + projectName + '\'' +
                ", description='" + description + '\'' +
                ", entry type='" +  super.getEntryType() + '\'' +
                '}';
    }
}

