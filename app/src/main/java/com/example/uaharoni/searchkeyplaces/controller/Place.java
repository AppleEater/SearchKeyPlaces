package com.example.uaharoni.searchkeyplaces.controller;

import android.media.Image;

import com.example.uaharoni.searchkeyplaces.controller.Address;

public class Place {
    String name;
    Address address;
    Image image;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Phone[] getPhones() {
        return phones;
    }

    public void setPhones(Phone[] phones) {
        this.phones = phones;
    }
}
