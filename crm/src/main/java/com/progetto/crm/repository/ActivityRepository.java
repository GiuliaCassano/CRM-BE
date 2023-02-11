package com.progetto.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.progetto.crm.model.Activity;
public interface ActivityRepository extends JpaRepository<Activity, Long>{
    /*1 */ public Activity findByManager(String manager);
    /*2 */ public Activity findByActivityType(String activityType);
   
}
