package com.progetto.crm.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Activity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String activityType;

    @Column
    private LocalDate dateTime;

    @Column
    private String manager;

    @Column
    private String description;

    @ManyToMany (mappedBy = "activities")
    @JsonIncludeProperties({"id", "firstName", "lastName", "country", "email", "phoneNumber"})
    private List<Contact> contacts;

    public Activity(String activityType, LocalDate dateTime, String manager, String description, List<Contact> contacts) {
        this.activityType = activityType;
        this.dateTime = dateTime;
        this.manager = manager;
        this.description = description;
        this.contacts = contacts;
    }

    
}
