package com.country.app.countries_api.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Countries {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "countries_id_seq")
    @SequenceGenerator(
            name = "countries_id_seq",
            sequenceName = "countries_id_seq",
            allocationSize = 1,
            initialValue = 1)
    private int id;
    private String username;
    private float area;
    private Date nationalDay;
    private String country_code2;
    private String countryCode3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public Date getNationalDay() {
        return nationalDay;
    }

    public void setNationalDay(Date nationalDay) {
        this.nationalDay = nationalDay;
    }

    public String getCountry_code2() {
        return country_code2;
    }

    public void setCountry_code2(String country_code2) {
        this.country_code2 = country_code2;
    }

    public String getCountryCode3() {
        return countryCode3;
    }

    public void setCountryCode3(String countryCode3) {
        this.countryCode3 = countryCode3;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", area=" + area +
                ", nationalDay=" + nationalDay +
                ", country_code2='" + country_code2 + '\'' +
                ", countryCode3='" + countryCode3 + '\'' +
                '}';
    }
}
