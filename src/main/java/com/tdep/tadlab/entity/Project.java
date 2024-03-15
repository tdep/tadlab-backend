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

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectId;

    @Setter
    private String projectName;

    @Setter
    private String description;

    public Project(Long projectId, String projectName, String description, EntryType entryType) {
        super(entryType);
        this.projectId = projectId;
        this.projectName = projectName;
        this.description = description;
    }
    public Project() {
        super();
    }

    @Override
    public String toString() {
        return  "Url{" +
                ", name='" + super.getName() + '\'' +
                ", entry type='" +  + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

