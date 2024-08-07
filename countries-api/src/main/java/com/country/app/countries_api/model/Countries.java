package com.country.app.countries_api.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Countries {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "countries_country_id_seq")
    @SequenceGenerator(
            name = "countries_country_id_seq",
            sequenceName = "countries_country_id_seq",
            allocationSize = 1,
            initialValue = 1)
    private int countryId;
    private String name;
    private float area;
    private Date nationalDay;
    private String countryCode2;
    private String countryCode3;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCountryCode2() {
        return countryCode2;
    }

    public void setCountryCode2(String countryCode2) {
        this.countryCode2 = countryCode2;
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
                "countryId=" + countryId +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", nationalDay=" + nationalDay +
                ", countryCode2='" + countryCode2 + '\'' +
                ", countryCode3='" + countryCode3 + '\'' +
                '}';
    }
}
