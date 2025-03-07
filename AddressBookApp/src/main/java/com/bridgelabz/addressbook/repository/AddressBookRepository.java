package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Create an interface AddressRepository to extend the JpaRepository interface to perform CRUD operation in database
@Repository
public interface AddressBookRepository extends JpaRepository<Address,String> {

}
