package com.progetto.crm;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.progetto.crm.model.Activity;
import com.progetto.crm.model.Contact;
import com.progetto.crm.service.ActivityService;
import com.progetto.crm.service.ContactService;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    ContactService contactService;

    @Autowired
    ActivityService activityService;

    @Override
    public void run(String... args) throws Exception {
        
        
         //ACTIVITY
         
        Activity activity1 = new Activity("Meeting call", LocalDateTime.of(2023, 2, 21, 12, 30), "Tomaso Goffredo", "Agenda: Salary review", null);
        Activity activity2 = new Activity("Email", LocalDateTime.of(2023, 3, 01, 11, 45), "Laura Munoz", "Recruiting new marketing specialist", null);
        Activity activity3 = new Activity("PR interview", LocalDateTime.of(2023, 2, 15, 9, 15), "Sara Kirk", "Market trend", null);
        
        activityService.save(activity1);
        activityService.save(activity2);
        activityService.save(activity3);
        

        List<Activity> firstActivityList = new ArrayList<>();
        firstActivityList.add(activity1);
        firstActivityList.add(activity2);
        
        List<Activity> secondActivityList = new ArrayList<>();
        secondActivityList.add(activity2);
        secondActivityList.add(activity3);

        List<Activity> thirdActivityList = new ArrayList<>();
        thirdActivityList.add(activity1);
        thirdActivityList.add(activity3);

        //CONTACTS

        Contact contact1 = new Contact("Giulia", "Cassano", "Italy", "giuliacassano1993@gmail.com", "3341076040", firstActivityList);
        Contact contact2 = new Contact("Andrew", "Brown", "United Kingdom", "andrew.brown@gmail.com", "3482639003", secondActivityList);
        Contact contact3 = new Contact("Steven", "Johnson", "United States of America", "steven.johnson@gmail.com", "5279446921", firstActivityList);
        Contact contact4 = new Contact("Cristina", "Palacios", "Spain", "cristina.palacios@adecco.es", "6859375308", thirdActivityList);
        Contact contact5 = new Contact("Luciana", "Villanueva", "Spain", "luciana.villanueva@adecco.es", "6859375308", thirdActivityList);
        Contact contact6 = new Contact("Raffaella", "Tarantola", "Italy", "raffaella.tarantola@adecco.es", "6859375308", thirdActivityList);
        Contact contact7 = new Contact("Mary", "Moore", "United Kingdom", "mary.moore@adecco.es", "6859375308", firstActivityList);
        Contact contact8 = new Contact("Thomas", "Hanks", "United States of America", "thomas.hanks@adecco.es", "6859375308", thirdActivityList);
        Contact contact9 = new Contact("Eugene", "Laurant", "France", "eugene.laurant@adecco.es", "6859375308", thirdActivityList);
        Contact contact10 = new Contact("Sam", "Smith", "United States of America", "sam.smith@adecco.es", "6859375308", firstActivityList);
        Contact contact11 = new Contact("Paul", "McCartney", "United Kingdom", "paul.beatles@adecco.es", "6859375308", thirdActivityList);
        Contact contact12 = new Contact("Christopher", "Brown", "United States of America", "chris.brown@adecco.es", "6859375308", thirdActivityList);
        Contact contact13 = new Contact("Barbara", "Streisand", "Spain", "barbarastreisand@adecco.es", "6859375308", firstActivityList);
        Contact contact14 = new Contact("Martin", "King", "United Kingdom", "martin.king@adecco.es", "6859375308", secondActivityList);
        Contact contact15 = new Contact("Ines", "Iglesias", "Spain", "ines.iglesias@adecco.es", "6859375308", thirdActivityList);
        Contact contact16 = new Contact("Peter", "Jackson", "United States of America", "peter.jackson@adecco.es", "6859375308", thirdActivityList);
        Contact contact17 = new Contact("Joanna", "Enriquez", "Spain", "joanna.enriquez@adecco.es", "6859375308", firstActivityList);
        Contact contact18 = new Contact("Petra", "Flamingos", "Spain", "petra.flamingos@adecco.es", "6859375308", secondActivityList);
        Contact contact19 = new Contact("Henry", "Styles", "United Kingdom", "henry.styles@adecco.es", "6859375308", thirdActivityList);
        Contact contact20 = new Contact("Bill", "Gates", "United States of America", "bill.gates@adecco.es", "6859375308", secondActivityList);

        contactService.save(contact1);
        contactService.save(contact2);
        contactService.save(contact3);
        contactService.save(contact4);
        contactService.save(contact5);
        contactService.save(contact6);
        contactService.save(contact7);
        contactService.save(contact8);
        contactService.save(contact9);
        contactService.save(contact10);
        contactService.save(contact11);
        contactService.save(contact12);
        contactService.save(contact13);
        contactService.save(contact14);
        contactService.save(contact15);
        contactService.save(contact16);
        contactService.save(contact17);
        contactService.save(contact18);
        contactService.save(contact19);
        contactService.save(contact20);


         

    }
    
}
