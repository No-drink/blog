package com.joey.pojo;

public class Blog {
    private Integer id;
    private String image;
    private String title;
    private String text;

    public Blog() {
    }

    public Blog(Integer id, String image, String title, String text) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
