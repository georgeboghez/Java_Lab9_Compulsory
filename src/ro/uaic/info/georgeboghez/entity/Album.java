package ro.uaic.info.georgeboghez.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * To be able to store Album objects in the database (schmema 'MUSICALBUMS', table 'ALBUMS')  using JPA we need to define an entity class. A JPA entity class is a POJO (Plain Old Java Object) class, i.e. an ordinary Java class that is marked (annotated) as having the ability to represent objects in the database. Conceptually this is similar to serializable classes, which are marked as having the ability to be serialized.
 */
@Entity
@Table(schema = "JAVA_DBA", name = "ALBUMS")
public class Album {
    private long id;
    private String name;
    private Long releaseYear;
    private long artistId;

    public Album() {

    }

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "RELEASE_YEAR")
    public Long getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Long releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Basic
    @Column(name = "ARTIST_ID")
    public long getArtistId() {
        return artistId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return id == album.id &&
                Objects.equals(name, album.name) &&
                Objects.equals(releaseYear, album.releaseYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, releaseYear);
    }

    @Override
    public String toString() {
        return "Album(" + id +
                ", '" + name + '\'' +
                ", " + releaseYear +
                ", " + artistId +
                ')';
    }
}
