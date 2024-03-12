package com.tdep.tadlab.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;

    private UrlType urlType;

    @ManyToMany(mappedBy = "portfolio_entries")
    private Set<PortfolioEntry> portfolioEntries = new HashSet<>();

    public Url(String name, String url, UrlType urlType) {
        this.name = name;
        this.url = url;
        this.urlType = urlType;
    }

    public Url() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public void addPortfolioEntry(PortfolioEntry portfolioEntry) {
        boolean added = portfolioEntries.add(portfolioEntry);
        if (added) {
            portfolioEntry.getUrls().add(this);
        }
    }

    public void removePortfolioEntry(PortfolioEntry portfolioEntry) {
        boolean removed = portfolioEntries.remove(portfolioEntry);
        if (removed) {
            portfolioEntry.getUrls().remove(this);
        }
    }

    public UrlType getUrlType() {
        return urlType;
    }
    public void setUrlType(UrlType urlType) {
        this.urlType = urlType;
    }

    @Override
    public String toString() {
        return  "Url{" +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", url_type='" + urlType + '\'' +
                '}';
    }

    public Set<PortfolioEntry> getPortfolioEntries() {
        return portfolioEntries;
    }

    public void setPortfolioEntries(Set<PortfolioEntry> portfolioEntries) {
        this.portfolioEntries = portfolioEntries;
    }
}
