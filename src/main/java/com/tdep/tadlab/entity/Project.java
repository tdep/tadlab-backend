package com.tdep.tadlab.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project extends PortfolioEntry {

    @Column(name = "description")
    private String description;

    public Project(String name, EntryType entryType) {
        super(name, entryType);
    }
    public Project() {
    }

    public Project(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  "Url{" +
                ", name='" + super.getName() + '\'' +
                ", entry type='" + super.getEntryType() + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

