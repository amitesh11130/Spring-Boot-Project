package com.springbootapi.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Geo {
    private String lat;
    private String lng;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Company {
    private String name;
    private String catchPhrase;
    private String bs;
}
