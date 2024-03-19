package com.tdep.tadlab.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public class BasePortfolioEntryAudit extends BasePortfolioEntry implements Serializable {
    private String createdBy;
    private String updatedBy;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @Override // Sets default equals() method to also compare contents of an object, not just identity
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasePortfolioEntryAudit that)) return false;
        if (!super.equals(o)) return false;
        return createdBy.equals(that.createdBy) &&
                updatedBy.equals(that.updatedBy) &&
                createdAt.equals(that.createdAt) &&
                updatedAt.equals(that.updatedAt);
    }

    @Override // Returns the current instance of the class, necessary bc equals() being overidden
    public int hashCode() {
        return Objects.hash(super.hashCode(),
        createdBy, updatedBy, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return  "BasePortfolioEntryAudit{" +
                "createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                "}" +
                super.toString();
    }
}
