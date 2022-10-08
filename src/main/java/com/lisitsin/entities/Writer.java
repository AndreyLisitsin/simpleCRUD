package com.lisitsin.entities;

import java.util.List;

public class Writer {
    private long id;
    private String FirstName;
    private String LastName;
    private List<Post> posts;

    public Writer(String firstName, String lastName, List<Post> posts) {
        FirstName = firstName;
        LastName = lastName;
        this.posts = posts;
    }

    public Writer(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Writer{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", posts=" + posts +
                '}';
    }
}
