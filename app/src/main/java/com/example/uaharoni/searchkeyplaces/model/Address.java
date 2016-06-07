package com.example.uaharoni.searchkeyplaces.model;


public class Address {
    Long alat,aLong;
    String address, city,country;
    String addressName;

    public Address(String addressName, Long alat, Long aLong) {
        this.addressName = addressName;
        this.alat = alat;
        this.aLong = aLong;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressName() {
        return addressName;
    }

}
