package com.spring.boot.ds;




public class Cities {
    private Iterable<City> cities;

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
