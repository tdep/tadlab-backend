package com.tdep.tadlab.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "urls")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "url", nullable = false, length = 1024)
    private String url;

    @Column(name = "entry_id", nullable = false)
    private Long entryId;



    public Url(String name, String url, Long entryId) {
        this.name = name;
        this.url = url;
        this.entryId = entryId;
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

    public Long getEntryId() { return entryId; }
    public void setEntryId(Long entryId) { this.entryId = entryId; }

    @Override
    public String toString() {
        return  "Url{" +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
