package com.bridgelabz.addressbook.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Use different type of lombok annotation
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AddressBook")
//Create a class to define the person details
public class Address {
    //Create a private variable to store person record fullName, address, city, state, zipCode, and phoneNumber
    @Id
    private String fullName;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private Long phoneNumber;
}
