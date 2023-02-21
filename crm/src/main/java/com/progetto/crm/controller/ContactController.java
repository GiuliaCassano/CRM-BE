package com.progetto.crm.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.progetto.crm.model.Contact;
import com.progetto.crm.service.ContactService;



@CrossOrigin
@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    ContactService contactService;


    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAll(){
        return new ResponseEntity<>(contactService.findAll(), HttpStatus.OK);
    }
    
    // SAVE
    @PostMapping("/create")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact){
        return new ResponseEntity<>(contactService.save(contact), HttpStatus.CREATED);
    }

    // FINDBYEMAIL--CUSTOM
    @GetMapping("/find/email")
    public ResponseEntity<Contact> getContactByEmail(@RequestParam String email){
        return new ResponseEntity<>(contactService.findByEmail(email), HttpStatus.OK);
    }

    // UPDATE
    @PutMapping("/update")
    public ResponseEntity<Contact> updateContactById(@RequestParam Long id, @RequestBody Contact newContact){
        return new ResponseEntity<>(contactService.updateContact(id, newContact), HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteContact(@RequestParam Long id){

        if (contactService.findById(id).getActivities() != null){
            contactService.findById(id).setActivities(null);
        }
        contactService.deleteContact(id);
        return new ResponseEntity<>("Contact deleted", HttpStatus.OK);
    }
}
