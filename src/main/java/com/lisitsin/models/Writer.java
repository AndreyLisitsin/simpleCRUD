package com.lisitsin.models;

import java.util.List;
import java.util.Objects;

public class Writer {
    private Long id;
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


    public Writer(Long id, String firstName, String lastName, List<Post> posts) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        this.posts = posts;
    }

    public Writer(Long id, String firstName, String lastName) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
    }

    public long getId() {
        return id;
    }



    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Writer writer = (Writer) o;
        return id == writer.id && FirstName.equals(writer.FirstName) && LastName.equals(writer.LastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, FirstName, LastName);
    }
}
