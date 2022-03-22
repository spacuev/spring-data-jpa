package com.sepa.training.spring.data;

import com.sepa.service.country.demo.rest.CountryController;
import com.sepa.training.spring.data.entities.Country;
import com.sepa.training.spring.data.repositories.CountryRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
class DataApplicationTests {

	@Autowired
	CountryRepository repository;

	@Autowired
	ApplicationContext context;

	@Before
	public void setUp() {
	}

	@Test
	@DirtiesContext
	public void testCountryList() {

		List<Country> countryList = new ArrayList<>();

		final Iterable<Country> countries = repository.findAll();
		countries.forEach(countryList::add);
		assertNotNull(countryList);

		assertEquals(countryList.size(), 4);
	}

	@Test
	public void testCountryByCode() {
		final Country country = repository.getCountryByCode("USA");

		assertNotNull(country);
	}

	@Test
	public void testCountryChange() {

		Country country = repository.getCountryByCode("RUS");

		// get bean from SpringBoot starter
		final CountryController countryController = (CountryController) context.getBean("countryController");

		// request information from SpringBoot starter's bean about the country (including Population)
		final com.sepa.service.country.demo.model.Country countryInfo = countryController.getCountryInfo(country.getShortName());

		// update country - set actual population
		repository.updateCountryPopulationByCode("RUS", countryInfo.getPopulation());

		// check population
		country = repository.getCountryByCode("RUS");
		assertNotNull(country);

		assertEquals(countryInfo.getPopulation(), country.getPopulation());
	}
}
