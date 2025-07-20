package com.spring.boot.ds;


import com.spring.boot.entity.City;

public class Cities {
    private Iterable<City> cities;

    @SuppressWarnings("unused")
    public Cities() {
    }

    public Cities(Iterable<City> cities) {
        this.cities = cities;
    }

    public Iterable<City> getCities() {
        return cities;
    }

    public void setCities(Iterable<City> cities) {
        this.cities = cities;
    }
}
