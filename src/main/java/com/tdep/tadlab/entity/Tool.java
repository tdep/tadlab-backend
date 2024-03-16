package com.tdep.tadlab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "tools")
@PrimaryKeyJoinColumn(referencedColumnName = "entry_id")

public class Tool extends PortfolioEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tool_id")
    private long toolId;

    @Setter
    @Column(name = "tool_name")
    private String toolName;

    @Setter
    @Column(name = "link_id")
    private long linkId;

    @Setter
    @Column(name = "project_id")
    private long projectId;

    public Tool(String toolName, long linkId, long projectId, EntryType entryType) {
        super(entryType);
        this.toolName = toolName;
        this.linkId = linkId;
        this.projectId = projectId;
    }

    public Tool() { super(); }

    @Override
    public String toString() {
        return  "Tool{" +
                ", name='" + toolName + '\'' +
                ", name='" + linkId + '\'' +
                ", name='" + projectId + '\'' +
                ", name='" + super.getEntryType() + '\'' +
                '}';
    }
}
