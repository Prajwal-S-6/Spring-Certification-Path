package com.spring.rest.example3.controllers;

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
        representationModel.add(linkTo(methodOn(IndexController.class).index()).withSelfRel());
        representationModel.add(linkTo(methodOn(RestApiController.class).listCustomers()).withRel("customers"));
        return representationModel;
    }
}
