package com.tdep.tadlab.entity.projectDb;

import jakarta.persistence.*;

@Embeddable
public class ProjectDetail {

    private String description;

    public ProjectDetail(String description) {
        this.description = description;
    }

    public ProjectDetail() {

    }

    public String getDescription() { return description; }

    public void setDescription(String description) {this.description = description; }

    @Override
    public String toString() {
        return  "{" +
                "description='" + description + '\'' +
                '}';
    }

}
