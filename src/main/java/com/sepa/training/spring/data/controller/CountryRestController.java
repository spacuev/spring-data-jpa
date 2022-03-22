package com.sepa.training.spring.data.controller;

import com.sepa.training.spring.data.entities.Country;
import com.sepa.training.spring.data.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryRestController {

    @Autowired
    CountryService service;

    @GetMapping("/country")
    public List<Country> getCountries() {
        return service.getCountries();
    }

    @GetMapping("/country/{code}")
    public Country getCountryByCode(@PathVariable("code") String code) {
        return service.getCountryByCode(code);
    }

    @GetMapping("/country/{code}/population/{population}")
    public HttpStatus getCountryByCode(@PathVariable("code") String code, @PathVariable("population") int population) {
        try {
            service.updateCountryPopulationByCode(code, population);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.NO_CONTENT;
        }
    }
}
