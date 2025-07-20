package com.spring.boot.ds;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;



@Data
@Entity
@Builder
public class City {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    public City() {
    }

    public City(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public City(String a) {
        this.name = a;
    }
}
