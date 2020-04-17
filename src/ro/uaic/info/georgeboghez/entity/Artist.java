package ro.uaic.info.georgeboghez.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * To be able to store Artist objects in the database (schmema 'MUSICALBUMS', table 'ARTISTS')  using JPA we need to define an entity class. A JPA entity class is a POJO (Plain Old Java Object) class, i.e. an ordinary Java class that is marked (annotated) as having the ability to represent objects in the database. Conceptually this is similar to serializable classes, which are marked as having the ability to be serialized.
 */
@Entity
@Table(schema = "JAVA_DBA", name = "ARTISTS")
public class Artist {
    private long id;
    private String name;
    private String country;

    public Artist() {

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
    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return id == artist.id &&
                Objects.equals(name, artist.name) &&
                Objects.equals(country, artist.country);
    }

    @Override
    public String toString() {
        return "Artist(" + id +
                ", '" + name + '\'' +
                ", '" + country + '\'' +
                ')';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }
}
