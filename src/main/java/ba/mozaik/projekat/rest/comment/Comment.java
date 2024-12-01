package ba.mozaik.projekat.comment;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table (name ="comments")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String commnet;

    @Column(nullable = false)
    private String author;

    public Comment(long id) {
        this.id = id;
    }

    public Comment() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommnet() {
        return commnet;
    }

    public void setCommnet(String commnet) {
        this.commnet = commnet;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return name +"[" + id + "]";
    }
}
