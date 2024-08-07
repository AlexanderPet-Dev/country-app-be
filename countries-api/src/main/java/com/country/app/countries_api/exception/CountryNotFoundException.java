package com.country.app.countries_api.exception;

public class CountryNotFoundException extends RuntimeException{

    public CountryNotFoundException(Integer id){
        super("Could not find Country with id : " + id);
    }

    public CountryNotFoundException(String username){
        super("Could not find Country with name : " + username);
    }

}
