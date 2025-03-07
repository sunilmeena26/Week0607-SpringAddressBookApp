package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.entity.Address;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//Use @Service annotation
@Service
//Create a Service class that handles address-related operations such as adding, updating, deleting, and validating, addresses.
public class AddressBookService {
    //Create an object of useAddressRepository using AutoWired
    @Autowired
    AddressBookRepository useAddressRepository;

    //Create a method addRecord to add person details
    public String addRecord(Address address){
        //save data in h2 database
        useAddressRepository.save(address);
        //return the status after the data save
        return "Record Add Successfully";
    }

    //Create a method getRecordByName to get the employee details by user name
    public ResponseEntity<Address> getRecordByName(String personName){
        //return the person details
        Address address=useAddressRepository.findById(personName).orElse(null);
        //check the person is present or not
        if(address!=null){
            //return status and person details by name
            return new ResponseEntity<>(address,HttpStatus.OK);
        }else{
            //if not found than return status NOT_FOUND
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Create a method getAllRecord to display all person details
    public ResponseEntity<List<Address>> getAllRecord(){
        //return the person details using list
       return ResponseEntity.of(Optional.of(useAddressRepository.findAll()));
    }

    //Create a method updateRecord to update the person details using userName
    public ResponseEntity<String> updateRecord(Address address,String userName){
        Optional<Address> addressBook=useAddressRepository.findById(userName);
        //check person is exit or not in database
        if(addressBook.isPresent()){
            //store person details form database
            Address storePersonDetails=addressBook.get();
            storePersonDetails=address;
            storePersonDetails.setFullName(userName);
            useAddressRepository.save(storePersonDetails);
            //return the status after person details updated
            return new  ResponseEntity<>("Record Updated Successfully",HttpStatus.OK);
        }else{
            //return the status after person details not updated
            return new ResponseEntity<>("User Is Not Present",HttpStatus.NOT_MODIFIED);
        }
    }

    //Create a method deleteRecord to delete the person record using personName
    public ResponseEntity<String> deleteRecord(String personName){
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
