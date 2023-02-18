package com.progetto.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progetto.crm.model.Contact;
import com.progetto.crm.repository.ContactRepository;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    // SAVE--Ok
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    // FINDALL--Ok
    public List<Contact> findAll(){
        return contactRepository.findAll();
    }

    //FINDBYID
    public Contact findById(Long id){
        return contactRepository.findById(id).get(); //Senza il get ritorna un optional
    }

    // FINDBYEMAIL---->CUSTOM
    public Contact findByEmail(String email) {
        return contactRepository.findByEmail(email);
    }

    // UPDATE
    public Contact updateContact(Long id, Contact newContact){
        Optional<Contact> oldContactOpt = contactRepository.findById(id);  //Questo optional per accettare un possibile null come risultato
         if(oldContactOpt != null){
            Contact oldContact = oldContactOpt.get();
            oldContact.setFirstName(newContact.getFirstName());
            oldContact.setLastName(newContact.getLastName());
            oldContact.setCountry(newContact.getCountry());
            oldContact.setEmail(newContact.getEmail());
            oldContact.setPhoneNumber(newContact.getPhoneNumber());
            
            return contactRepository.save(oldContact);
        }
         
         return null;
     }

     // DELETE
     public void deleteContact(Long id){
        contactRepository.deleteById(id);

     }

     

     
    
}




