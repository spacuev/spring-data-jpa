package com.sepa.training.spring.data.repositories;

import com.sepa.training.spring.data.entities.Country;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

    Country getCountryByCode(String code);

    @Transactional
    @Modifying
    @Query("update Country c set c.population = :population where c.code = :code")
    int updateCountryPopulationByCode(@Param(value = "code") String code, @Param(value = "population") Integer population);
}
