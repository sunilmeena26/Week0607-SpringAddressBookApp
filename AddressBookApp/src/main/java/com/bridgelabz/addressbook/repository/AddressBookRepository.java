package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Create a interface AddressRepository to extend th JpaRepository interface
@Repository
public interface AddressBookRepository extends JpaRepository<Address,String> {

}
