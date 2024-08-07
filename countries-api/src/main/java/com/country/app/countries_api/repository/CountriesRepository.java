package com.country.app.countries_api.repository;

import com.country.app.countries_api.model.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountriesRepository extends JpaRepository<Countries, Integer> {
    Optional<Countries> findByName(String name);
}
