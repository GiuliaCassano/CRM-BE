package com.progetto.crm.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor 
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String country;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @ManyToMany 
    @JoinTable(name = "join_table")
    @JsonIncludeProperties({"id", "activityType", "dateTime", "manager", "description"})
    private List<Activity> activities;

    public Contact(String firstName, String lastName, String country, String email, String phoneNumber,
            List<Activity> activities) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.activities = activities;
    }
    
    
}
