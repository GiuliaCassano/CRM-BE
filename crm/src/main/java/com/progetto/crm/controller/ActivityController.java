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

import com.progetto.crm.model.Activity;
import com.progetto.crm.service.ActivityService;

@CrossOrigin
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    ActivityService activityService;

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<Activity>> getAll(){
        return new ResponseEntity<>(activityService.findAll(), HttpStatus.OK);
    }

    //SAVE
    @PostMapping("/create")
    public ResponseEntity<Activity> createActivity (@RequestBody Activity activity){
        return new ResponseEntity<>(activityService.save(activity), HttpStatus.OK);
    }

    //FINDBYACTIVITYTYPE
    @GetMapping("/find/activitytype")
    public ResponseEntity<Activity> getActivityByActivityType(@RequestParam String activityType){
        return new ResponseEntity<>(activityService.findByActivityType(activityType), HttpStatus.OK);
    }

    //FINDBYMANAGER
    @GetMapping("/find/manager")
    public ResponseEntity<Activity> getActivityByManager(@RequestParam String manager){
        return new ResponseEntity<>(activityService.findByActivityType(manager), HttpStatus.OK);
    }

    //UPDATE
    @PutMapping("/update")
    public ResponseEntity<Activity> updateActivityById(@RequestParam Long id, @RequestBody Activity newActivity){
        return new ResponseEntity<>(activityService.updateActivity(id, newActivity), HttpStatus.OK);
    }
    //DELETE
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteActivity(@RequestParam Long id){
        activityService.deleteActivity(id);
        return new ResponseEntity<>("Activity deleted", HttpStatus.OK);
    }
}
