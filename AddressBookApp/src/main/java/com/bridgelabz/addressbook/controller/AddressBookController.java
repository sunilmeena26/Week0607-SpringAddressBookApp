package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.entity.Address;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Create a class AddressBookController for managing address book operations such as adding, updating, deleting, and retrieving addresses.
@RestController
@RequestMapping("/address")
public class AddressBookController {

    //Create an object of AddressBookService
    @Autowired
    AddressBookRepository useAddressRepository;

    //Create a method addRecord to add person details and take data in json format
    @PostMapping("/add")
    public String addRecord(@RequestBody Address record){
        //save data in h2 database
        useAddressRepository.save(record);
        //return the status after the data save
        return "Record Add Successfully";
    }

    //Create method getRecordByName to display person details using full name
    @GetMapping("/get/{personName}")
    public ResponseEntity<AddressBookDTO> getRecordByName(@PathVariable String personName){
        //return the person details
        Address record=useAddressRepository.findById(personName).orElse(null);
        //check the person is present or not
        if(record!=null){
            AddressBookDTO addressBookDTO=new AddressBookDTO(record.getFullName(),record.getAddress(),record.getCity(),record.getState(),record.getZipCode(),record.getPhoneNumber());
            //return status and person details by name
            return new ResponseEntity<>(addressBookDTO, HttpStatus.OK);
        }else{
            //if not found than return status NOT_FOUND
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Create a method getAllRecord to display all details of a person from database
    @GetMapping("/getAll")
    public ResponseEntity<List<AddressBookDTO>> getAllRecord(){
        //Create a List to store person details from database
        List<Address> recordList=useAddressRepository.findAll();
        //Create a List of AddressBookDTO to store specific details of person data from dto class
        List<AddressBookDTO> recordDTOList=new ArrayList<>();
        //use for loop to iterate recordList
        for(Address address:recordList){
            //call the AddressBookDTO class constructor to initialize person specific details
            AddressBookDTO addressBookDTO=new AddressBookDTO(address.getFullName(),address.getAddress(),address.getCity(),address.getState(),address.getZipCode(),address.getPhoneNumber());
            //add AddressBookDTO person details in list
            recordDTOList.add(addressBookDTO);
        }
        //return the person details using list
        return ResponseEntity.of(Optional.of(recordDTOList));
    }

    //Create a method updateRecord to update the person details
    @PutMapping("/update/{personName}")
    public ResponseEntity<String> updateRecord(@RequestBody Address record,@PathVariable String personName){
        Optional<Address> addressBook=useAddressRepository.findById(personName);
        //check person is exit or not in database
        if(addressBook.isPresent()){
            //store person details form database
            Address storePersonDetails=addressBook.get();
            storePersonDetails=record;
            storePersonDetails.setFullName(personName);
            useAddressRepository.save(storePersonDetails);
            //return the status after person details updated
            return new  ResponseEntity<>("Record Updated Successfully",HttpStatus.OK);
        }else{
            //return the status after person details not updated
            return new ResponseEntity<>("User Is Not Present",HttpStatus.NOT_MODIFIED);
        }
    }

    //Create  method deleteRecord to delete the person record using personName
    @DeleteMapping("/delete/{personName}")
    public ResponseEntity<String> deleteRecord(@PathVariable String personName){
        Optional<Address> addressBook=useAddressRepository.findById(personName);
        //check person is present or not in database if exist than the delete form database
        if(addressBook.isPresent()){
            //delete person record using personName
            useAddressRepository.deleteById(personName);
            //return status after delete the record
            return new ResponseEntity<>("Record Deleted Successfully",HttpStatus.OK);
        }else{
            //return the status when person in not exist in database
            return new ResponseEntity<>("Record Is Not Deleted",HttpStatus.NO_CONTENT);
        }
    }
}
