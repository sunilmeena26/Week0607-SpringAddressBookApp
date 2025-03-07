package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.entity.Address;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//Use @Service annotation
@Service
//Create a Service class that handles address-related operations such as adding, validating, addresses.
public class AddressBookService {
    //Create an object of AddressRepository using AutoWired
    @Autowired
    AddressBookRepository addressRepository;

    //Create a method addRecord to add person details
    public String addRecord(Address address){
        //save data in h2 database
        addressRepository.save(address);
        //return the status after the data save
        return "Record Add Successfully";
    }

    //Create a method getRecordByName to get the employee details by user name
    public Address getRecordByName(String fullName){
        //return the person details
        return addressRepository.findById(fullName).orElse(null);
    }

    //Create a method getAllRecord to display all person details
    public List<Address> getAllRecord(){
        //return the person details using list
       return addressRepository.findAll();
    }
}
