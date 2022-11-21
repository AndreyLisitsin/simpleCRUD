package com.lisitsin.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "created")
    private Date created;
    @Column(name = "updated")
    private Date updated;

    @ManyToMany(cascade = {CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.EXTRA)
    @JoinTable(
            name = "post_label",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id")
    )
    private List<Label> labels;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @LazyCollection(LazyCollectionOption.EXTRA)
    @JoinColumn(name = "writer_id")
    private Writer writer;


    public Post() {
    }

    public Post(String content, Date created, Date updated, List<Label> labels, Writer writer) {
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.labels = labels;
        this.writer = writer;
    }

    public Post(String content, Date created, Date updated, List<Label> labels) {
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.labels = labels;
    }

    public Post(Long id, String content, Date created, Date updated, List<Label> labels) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.labels = labels;
    }

    public Post(Long id, String content, Date created, Date updated, List<Label> labels, Writer writer) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.labels = labels;
        this.writer = writer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(content, post.content) && Objects.equals(created, post.created) && Objects.equals(updated, post.updated) && Objects.equals(labels, post.labels) && Objects.equals(writer, post.writer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, created, updated, labels, writer);
    }
}



