package com.spring.mvc.example10.ds;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;



@Data
public class ShortAddress {
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
}
