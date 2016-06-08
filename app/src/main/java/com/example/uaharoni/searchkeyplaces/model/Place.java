package com.example.uaharoni.searchkeyplaces.model;

public class Place {
    String name;
    Address address;
    String imageUri;
    Phone[] phones;
    Long id;    //used for DB saving

    public Place(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getImage() {
        return imageUri;
    }

    public void setImage(String imageUri) {
        this.imageUri = imageUri;
    }

    public Phone[] getPhones() {
        return phones;
    }

    public void setPhones(Phone[] phones) {
        this.phones = phones;
    }
}
