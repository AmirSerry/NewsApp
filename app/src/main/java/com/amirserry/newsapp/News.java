package com.amirserry.newsapp;

import java.io.Serializable;

public class News implements Serializable {

    private String title;
    private String name;
    private String autherName;
    private String datePublished;
    private String webURL;

    public News(String title, String name, String webURL, String autherName, String datePublished) {
        this.title = title;
        this.name = name;
        this.webURL = webURL;
        this.autherName = autherName;
        this.datePublished = datePublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }

    public String getAutherName() {
        return autherName;
    }

    public void setAutherName(String autherName) {
        this.autherName = autherName;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }
}
