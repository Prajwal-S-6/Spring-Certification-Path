package com.spring.boot.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Cities {
    private Iterable<City> cities;

    public Cities() {
    }

    public Cities(Iterable<City> cities) {
        this.cities = cities;
    }
}
