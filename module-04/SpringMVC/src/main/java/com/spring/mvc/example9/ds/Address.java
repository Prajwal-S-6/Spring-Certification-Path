package com.spring.mvc.example9.ds;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


import static jakarta.persistence.GenerationType.IDENTITY;


@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @NotBlank(message = "First name cannot be empty")
    @Pattern(regexp = "[A-Za-z-']*", message = "First name contains illegal characters")
    private String firstName;
    @NotBlank(message = "Last name cannot be empty")
    @Pattern(regexp = "[A-Za-z-']*", message = "Last name contains illegal characters")
    private String lastName;
    @NotBlank(message = "Street address cannot be empty")
    @Pattern(regexp = "[\\w .\\-/]*", message = "Street address contains illegal characters")
    private String streetAddress;
    @NotBlank(message = "City name cannot be empty")
    @Pattern(regexp = "[A-Za-z \\-]*", message = "City name contains illegal characters")
    private String city;
    @Pattern(regexp = "[A-Z]{2}", message = "State code needs to be 2 letter code")
    private String stateCode;
    @Pattern(regexp = "\\d{5}", message = "ZIP code needs to be 5 digit US ZIP code")
    private String zipCode;
    @NotBlank(message = "Country name cannot be empty")
    @Pattern(regexp = "[A-Za-z ]*", message = "Country name contains illegal characters")
    private String country;

    public Address() {
    }

    public Address(Person person, ShortAddress shortAddress, Country country) {
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.streetAddress = shortAddress.getStreetAddress();
        this.city = shortAddress.getCity();
        this.stateCode = shortAddress.getStateCode();
        this.zipCode = shortAddress.getZipCode();
        this.country = country.getCountry();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
