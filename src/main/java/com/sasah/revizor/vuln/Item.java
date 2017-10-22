package com.sasah.revizor.vuln;

public class Item {

    private String severity;
    private String title;
    private String link;
    private String versions;

    public Item(String severity, String title, String link, String versions) {
        this.severity = severity;
        this.title = title;
        this.link = link;
        this.versions = versions;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getVersions() {
        return versions;
    }

    public void setVersions(String versions) {
        this.versions = versions;
    }

}
