package com.spring.test.ds;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Room {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String name;
    private String section;

    @SuppressWarnings("unused")
    public Room() {
    }

    public Room(String name, String section) {
        this.name = name;
        this.section = section;
    }

    public Room(Integer id, String name, String section) {
        this.id = id;
        this.name = name;
        this.section = section;
    }

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
