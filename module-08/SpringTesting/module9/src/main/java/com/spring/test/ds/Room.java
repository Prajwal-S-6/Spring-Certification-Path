package com.spring.test.ds;


import jakarta.persistence.*;

import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "rooms")
public class Room implements Identifiable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "section")
    private String section;

    @SuppressWarnings("unused")
    Room() {
    }

    public Room(String name, String section) {
        this(null, name, section);
    }

    public Room(Integer id, String name, String section) {
        this.id = id;
        this.name = name;
        this.section = section;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Room room)) return false;
        return Objects.equals(getId(), room.getId()) && Objects.equals(getName(), room.getName()) && Objects.equals(getSection(), room.getSection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSection());
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", section='" + section + '\'' +
                '}';
    }
}
