package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.entity.Address;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Create a class AddressBookController for managing address book operations such as adding, updating, deleting, and retrieving addresses.
@RestController
@RequestMapping("/address")
public class AddressBookController {

    //Create an object of AddressBookService
    @Autowired
    AddressBookService useAddressService;

    //Create a method addRecord to add person details and take data in json format
    @PostMapping("/add")
    public String addRecord(@RequestBody Address address){
        //call the addRecord method to and result status
        return useAddressService.addRecord(address);
    }

    //Create method getRecordByName to display person details using full name
    @GetMapping("/get/{personName}")
    public ResponseEntity<AddressBookDTO> getRecordByName(@PathVariable String personName){
        //return the person details using name
        return useAddressService.getRecordByName(personName);
    }

    //Create a method getAllRecord to display all details of a person from database
    @GetMapping("/getAll")
    public ResponseEntity<List<AddressBookDTO>> getAllRecord(){
        //return the all person details
        return useAddressService.getAllRecord();
    }

    //Create a method updateRecord to update the person details
    @PutMapping("/update/{personName}")
    public ResponseEntity<String> updateRecord(@RequestBody Address address,@PathVariable String personName){
        //call the method updateRecord of service class to update the record
        return useAddressService.updateRecord(address,personName);
    }

    //Create  method deleteRecord to delete the person record using personName
    @DeleteMapping("/delete/{personName}")
    public ResponseEntity<String> deleteRecord(@PathVariable String personName){
        //call the method of service class for deleting record
        return useAddressService.deleteRecord(personName);
    }
}
