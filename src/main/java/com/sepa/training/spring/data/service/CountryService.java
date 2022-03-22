package com.sepa.training.spring.data.service;

import com.sepa.training.spring.data.entities.Country;
import com.sepa.training.spring.data.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    CountryRepository repository;

    public List<Country> getCountries() {

        List<Country> countryList = new ArrayList<>();

        final Iterable<Country> countries = repository.findAll();
        countries.forEach(countryList::add);

        return countryList;
    }

    public Country getCountryByCode(String code) {
        return repository.getCountryByCode(code);
    }

    public void updateCountryPopulationByCode(String code, int population) {
        repository.updateCountryPopulationByCode(code, population);
    }
}
