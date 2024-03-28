package com.tdep.tadlab.entity.projectDb;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.tdep.tadlab.entity.common.BasePortfolioEntryAudit;
import com.tdep.tadlab.entity.common.EntryType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "jobs")
public class Job extends BasePortfolioEntryAudit {

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    @JsonFormat(pattern = "yyyy-MM")
    private Date startDate;

    @Column(name = "end_date")
    @JsonFormat(pattern = "yyyy-MM")
    private Date endDate;

    @Embedded
    private JobDetail jobDetail;

    public Job(
            String entryName,
            EntryType entryType,
            String createdBy,
            Date createdAt,
            String name,
            Date startDate,
            Date endDate,
            JobDetail jobDetail) {
        super.setEntryName(entryName);
        super.setEntryType(entryType);
        super.setCreatedBy(createdBy);
        super.setCreatedAt(createdAt);
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobDetail = jobDetail;
    }

    public Job() {

    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Date getStartDate() { return startDate; }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public JobDetail getJobDetail() {
        return jobDetail;
    }

    public void setJobDetail(JobDetail jobDetail) {
        this.jobDetail = jobDetail;
    }

    @Override
    public String toString() {
        return  "{" +
                "name='" + name + '\'' +
                ", start date='" + startDate + '\'' +
                ", end date='" + endDate + '\'' +
                "}" +
                super.toString();
    }
}
