package com.lisitsin.models;

import lombok.Builder;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "writer", schema = "socialweb")
@Builder
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String FirstName;
    @Column(name = "last_name")
    private String LastName;
    @OneToMany(mappedBy = "writer", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @LazyCollection(LazyCollectionOption.EXTRA)
    private List<Post> posts;

    public Writer() {
    }

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
