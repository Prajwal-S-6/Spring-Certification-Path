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
    private UUID id;
    @Column(unique = true)
    private String name;
    private String section;

    @SuppressWarnings("unused")
    Room() {
    }

    public Room(String name, String section) {
        this.name = name;
        this.section = section;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSection() {
        return section;
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
