package com.bridgelabz.addressbook.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Use different type of lombok annotation
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// Create a AddressBookDTO (Data Transfer Object) class for AddressBook, used to transfer address-related data between layers of the application.
public class AddressBookDTO {
        //Create a private variable to store person record fullName, address, city, state, zipCode, and phoneNumber
        @Id
        private String fullName;
        private String address;
        private String city;
        private String state;
        private int zipCode;
        private Long phoneNumber;
}
