package com.lisitsin.models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Post {
    private Long id;
    private String content;
    private Date created;
    private Date updated;
    private List<Label> labels;

    private long writerId;

    public Post(Long id, String content, Date created, Date updated, List<Label> labels, long writerId) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.labels = labels;
        this.writerId = writerId;
    }

    public Post(String content, Date created, Date updated, List<Label> labels) {
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.labels = labels;
    }

    public Post() {
        this.created = new Date();
        this.updated = new Date();
    }

    public Post(Long id, String content, Date created, Date updated, List<Label> labels) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.labels = labels;
    }

    public void setId(Long id){
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

    public long getWriter_id() {
        return writerId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", labels=" + labels +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id && writerId == post.writerId && content.equals(post.content) && created.equals(post.created) && updated.equals(post.updated) && Objects.equals(labels, post.labels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, created, updated, labels, writerId);
    }
}



