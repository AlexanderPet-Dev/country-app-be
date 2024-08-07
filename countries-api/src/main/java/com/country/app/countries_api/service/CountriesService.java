package com.country.app.countries_api.service;

import com.country.app.countries_api.exception.CountryNotFoundException;
import com.country.app.countries_api.model.Countries;
import com.country.app.countries_api.repository.CountriesRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CountriesService {

    private static final Logger log = LoggerFactory.getLogger(CountriesService.class);

    @Autowired
    CountriesRepository countriesRepository;

    /**
     * get all countries
     * @return List<Countries>
     */
    public List<Countries> getAllCountries() {
        log.debug("CountriesService - getAllCountries");
        return countriesRepository.findAll();
    }

    /**
     * get country by id
     * @param id
     * @return Countries
     */
    public Countries getCountryById(Integer id) {
        log.debug("CountriesService - getCountryById");
        return countriesRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));
    }

    /**
     * get country by name
     * @param name
     * @return Countries
     */
    public Countries getCountryByName(String name) {
        log.debug("CountriesService - getCountryByName");
        return countriesRepository.findByName(name)
                .orElseThrow(() -> new CountryNotFoundException(name));
    }

    /**
     * Create countries
     * @param countries of {@type:Countries}
     */
    public ResponseEntity<String> createCountries(Countries countries) {
        log.debug("CountriesService - createCountries");
        ResponseEntity<String> responseEntity;
        try {
            countriesRepository.save(countries);
            responseEntity = ResponseEntity.ok("Country with name "  + countries.getName() + " was created.");
        } catch (Exception e) {
            responseEntity = ResponseEntity.ok("Country with name "  + countries.getName() + " could not be created.");
        }
        return responseEntity;
    }

    /**
     * Update countries
     * @param countries of {@type:Countries}
     */
    public ResponseEntity<String> updateCountries(Countries countries) {
        log.debug("CountriesService - updateCountries");
        Countries currentCountry = countriesRepository.findById(countries.getCountryId())
                .orElseThrow(() -> new CountryNotFoundException(countries.getCountryId()));
        countriesRepository.save(countries);
        return ResponseEntity.ok("Country with name " + currentCountry.getName() + " was updated.");
    }

    /**
     * Delete countries
     * @param id of {@type:Integer}
     * @return responseEntity of {@type:ResponseEntity}
     */
    public ResponseEntity<String> deleteCountries(Integer id) {
        log.debug("CountriesService - deleteCountries");
        Countries countryToDelete = countriesRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));
        countriesRepository.delete(countryToDelete);
        return ResponseEntity.ok("Country with name " + countryToDelete.getName() + " was deleted.");
    }

}
