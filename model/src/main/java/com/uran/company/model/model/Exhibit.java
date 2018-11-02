package com.uran.company.model.model;

import java.util.List;

public class Exhibit {

    private String title;
    private List<String> images;

    public String getTitle() {
        return title;
    }

    public List<String> getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "Exhibit{" + "title='" + title + '\'' + ", images=" + images + '}';
    }
}
