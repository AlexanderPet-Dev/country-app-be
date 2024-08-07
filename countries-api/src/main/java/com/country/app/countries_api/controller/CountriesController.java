package com.country.app.countries_api.controller;

import com.country.app.countries_api.model.Countries;
import com.country.app.countries_api.service.CountriesService;
import jakarta.validation.Valid;
import org.hibernate.Internal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api")
public class CountriesController {

    private static final Logger log = LoggerFactory.getLogger(CountriesController.class);

    @Autowired
    CountriesService countriesService;

    @GetMapping("/countries")
    public @ResponseBody CollectionModel<EntityModel<Countries>> getAllCountries() {
        List<EntityModel<Countries>> countries = countriesService
                .getAllCountries()
                .stream()
                .map(country -> EntityModel.of(country,
                        linkTo(methodOn(CountriesController.class).getCountryById(country.getCountryId())).withSelfRel(),
                        linkTo(methodOn(CountriesController.class).getCountryByName(country.getName())).withSelfRel(),
                        linkTo(methodOn(CountriesController.class).getAllCountries()).withRel("countries")))
                .collect(Collectors.toList());
        return CollectionModel.of(countries, linkTo(methodOn(CountriesController.class).getAllCountries()).withSelfRel());

    }

    @GetMapping("/countries/{id}")
    public @ResponseBody EntityModel<Countries> getCountryById(@PathVariable("id") Integer id) {
        log.debug("UserController - getUsersById");
        Countries country = countriesService.getCountryById(id);
        return EntityModel.of(country,
                linkTo(methodOn(CountriesController.class).getCountryById(id)).withSelfRel(),
                linkTo(methodOn(CountriesController.class).getCountryByName(country.getName())).withSelfRel(),
                linkTo(methodOn(CountriesController.class).getAllCountries()).withRel("countries"));
    }

    @GetMapping("/countries/name/{name}")
    public @ResponseBody EntityModel<Countries> getCountryByName(@PathVariable("name") String name) {
        log.debug("CountriesController - getCountryByName");
        Countries country = countriesService.getCountryByName(name);
        return EntityModel.of(country,
                linkTo(methodOn(CountriesController.class).getCountryById(country.getCountryId())).withSelfRel(),
                linkTo(methodOn(CountriesController.class).getCountryByName(name)).withSelfRel(),
                linkTo(methodOn(CountriesController.class).getAllCountries()).withRel("countries"));
    }

    /**
     * path /countries will create countries
     * @param countries of {@type:Countries}
     * @return  message on successful/unsuccessful countries creation of {@type:ResponseEntity}
     */
    @PostMapping("/countries")
    public ResponseEntity<String> createCountries(@RequestBody @Valid Countries countries) {
        log.debug("CountriesController - createCountries");
        return countriesService.createCountries(countries);
    }

    /**
     * path /countries will update countries
     * @param countries of {@type:Countries}
     * @return message on successful/unsuccessful countries update of {@type:ResponseEntity}
     */
    @PatchMapping("/countries")
    public ResponseEntity<String> updateCountries(@RequestBody @Valid Countries countries) {
        log.debug("CountriesController - updateCountries");
        return countriesService.updateCountries(countries);
    }

    /**
     * path /countries will delete countries
     * @param id of {@type:Integer}
     * @return message on successful/unsuccessful countries deletion of {@type:ResponseEntity}
     */
    @DeleteMapping("/countries")
    public ResponseEntity<String> deleteCountries(@RequestParam("id") Integer id) {
        log.debug("CountriesController - deleteCountries");
        return countriesService.deleteCountries(id);
    }



}
