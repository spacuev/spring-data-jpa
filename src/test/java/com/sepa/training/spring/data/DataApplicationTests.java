package com.sepa.training.spring.data;

import com.sepa.training.spring.data.entities.Country;
import com.sepa.training.spring.data.repositories.CountryRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
class DataApplicationTests {

	@Autowired
	CountryRepository repository;

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

		repository.updateCountryPopulationByCode("RU", 145000000);

		final Country country = repository.getCountryByCode("RU");
		assertNotNull(country);

		assertEquals(145000000, country.getPopulation());
	}
}
