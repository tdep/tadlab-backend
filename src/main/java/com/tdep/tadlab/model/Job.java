package com.tdep.tadlab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name="jobs")
public class Job {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String title;
  private Date startDate;
  private Date endDate;
  private String description;

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public String getTitle() { return title; }

  public void setTitle(String title) { this.title = title; }

  public Date getStartDate() { return startDate; }

  public void setStartDate(Date startDate) { this.startDate = startDate; }

  public Date getEndDate() { return endDate; }

  public void setEndDate(Date endDate) { this.endDate = endDate; }

  public String getDescription() { return description; }

  public void setDescription(String description) { this.description = description; }
}
