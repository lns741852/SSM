package com.java.bean;

public class Authority {
    private Long id;

    private String authorityName;

    private String authorityUrl;

    private Long parent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName == null ? null : authorityName.trim();
    }

    public String getAuthorityUrl() {
        return authorityUrl;
    }

    public void setAuthorityUrl(String authorityUrl) {
        this.authorityUrl = authorityUrl == null ? null : authorityUrl.trim();
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }
}