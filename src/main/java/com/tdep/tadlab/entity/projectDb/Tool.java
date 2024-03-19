package com.tdep.tadlab.entity.projectDb;

import com.tdep.tadlab.entity.common.BasePortfolioEntryAudit;
import com.tdep.tadlab.entity.common.EntryType;
import jakarta.persistence.*;

@Entity
@Table(name = "tool")
public class Tool extends BasePortfolioEntryAudit {

    @OneToOne(
            mappedBy = "tools",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @PrimaryKeyJoinColumn(referencedColumnName = "id")
    private Link iconLink;

    public Tool(String entryName, EntryType entryType, Link iconLink) {
        super.setEntryName(entryName);
        super.setEntryType(entryType);
        this.iconLink = iconLink;
    }

    public Tool() {

    }

    public Link getIconLink() {
        return iconLink;
    }

    public void setIconLink(Link iconLink) {
        this.iconLink = iconLink;
    }

    @Override
    public String toString() {
        return  "{" +
                ", icon link='" + iconLink + '\'' +
                '}' +
                super.toString();
    }
}
