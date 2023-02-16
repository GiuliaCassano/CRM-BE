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

        contactService.save(contact1);
        contactService.save(contact2);
        contactService.save(contact3);
        contactService.save(contact4);

  

         

    }
    
}
