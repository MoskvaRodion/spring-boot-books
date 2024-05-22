package com.campus.spring.book.entity;

public class BookEntity {
    private Integer ID;
    private String title;
    private String description;

    public BookEntity() {
    }

    public BookEntity(Integer ID, String title, String description) {
        this.ID = ID;
        this.title = title;
        this.description = description;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
