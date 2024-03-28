package com.tdep.tadlab.entity.projectDb;

import jakarta.persistence.Embeddable;

@Embeddable
public class JobDetail {

    private String title;

    private String description;

    public JobDetail(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public JobDetail() {

    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return  "{" +
                "title='" + title + '\'' +
                "description='" + description + '\'' +
                '}';
    }

}
