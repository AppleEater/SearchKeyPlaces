package com.example.uaharoni.searchkeyplaces.model;


public class Address {
    Long alat,aLong;
    String street, building, apartment, city,country;
    String addressName;

    public Address(String addressName, Long alat, Long aLong) {
        this.addressName = addressName;
        this.alat = alat;
        this.aLong = aLong;
    }

    public Address(String addressName, String street, String building, String apartment, String city, String country, Long aLong, Long alat) {
        this.addressName = addressName;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
        this.city = city;
        this.country = country;
        this.aLong = aLong;
        this.alat = alat;
    }

    public Long getAlat() {
        return alat;
    }

    public void setAlat(Long alat) {
        this.alat = alat;
    }

    public Long getaLong() {
        return aLong;
    }

    public void setaLong(Long aLong) {
        this.aLong = aLong;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressName() {
        return addressName;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
