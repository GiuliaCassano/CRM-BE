package com.progetto.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progetto.crm.model.Activity;
import com.progetto.crm.repository.ActivityRepository;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;
    
    //SAVE
    public Activity save(Activity activity){
        return activityRepository.save(activity);
    }

    //FINDALL
    public List<Activity> findAll(){
        return activityRepository.findAll();
    }

    //FINDBYID
    public Activity findById(Long id){ 
        return activityRepository.findById(id).get();
    }

    //FINDBYACTIVITYTYPE
    public Activity findByActivityType(String activityType){
        return activityRepository.findByActivityType(activityType);
    }

    //FINDBYMANAGER
    public Activity findByManager(String manager){
        return activityRepository.findByManager(manager);
    }

    //UPDATE
    public Activity updateActivity(Long id, Activity newActivity){
        Optional<Activity> oldActivityOpt = activityRepository.findById(id);  //Questo optional per accettare un possibile null come risultato
         if(oldActivityOpt != null){
            Activity oldActivity = oldActivityOpt.get();
            oldActivity.setActivityType(newActivity.getActivityType());
            oldActivity.setDateTime(newActivity.getDateTime());
            oldActivity.setDescription(newActivity.getDescription());
            
            return activityRepository.save(oldActivity);
        }
         
         return null;
     }

    //DELETE
     public void deleteActivity(Long id){
        activityRepository.deleteById(id);
     }

}
