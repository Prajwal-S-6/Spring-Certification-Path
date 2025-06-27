package com.spring.rest.example11.controllers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class IndexController {

    @GetMapping("/")
    public RepresentationModel index() {
        RepresentationModel representationModel = new RepresentationModel();
        return representationModel.add(linkTo(methodOn(CustomerApiController.class).listAllCustomers()).withRel("customers"),
                linkTo(methodOn(IndexController.class).index()).withSelfRel());
    }
}
