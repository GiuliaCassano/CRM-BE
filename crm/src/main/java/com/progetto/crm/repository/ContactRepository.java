package com.progetto.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.progetto.crm.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{
    /*1*/ public Contact findByEmail(String email);
}
