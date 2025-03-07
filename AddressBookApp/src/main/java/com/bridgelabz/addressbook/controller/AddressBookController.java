package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.entity.Address;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Create a class AddressBookController for managing address book operations such as adding, and retrieving addresses.
@RestController
@RequestMapping("/address")
public class AddressBookController {

    //Create an object of AddressBookService
    @Autowired
    AddressBookService addressService;

    //Create a method addRecord to add person details and take data in json format
    @PostMapping("/add")
    public String addRecord(@RequestBody Address address){
        //call the addRecord method to and result status
        return addressService.addRecord(address);
    }

    //Create method getRecordByName to display person details using full name
    @GetMapping("/get/{fullName}")
    public Address getRecordByName(@PathVariable String fullName){
        //return the person details using name
        return addressService.getRecordByName(fullName);
    }

    //Create a method getAllRecord to display all details of a person from database
    @GetMapping("/getAll")
    public List<Address> getAllRecord(){
        //return the all person details
        return addressService.getAllRecord();
    }

}
