package com.joey.pojo;

public class Blog {
    private Integer index;
    private String image;
    private String title;
    private String text;

    public Blog() {
    }

    public Blog(Integer index, String image, String title, String text) {
        this.index = index;
        this.image = image;
        this.title = title;
        this.text = text;
    }

    public Blog(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Blog(String image, String title, String text) {
        this.image = image;
        this.title = title;
        this.text = text;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "index=" + index +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
