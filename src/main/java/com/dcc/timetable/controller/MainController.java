package com.dcc.timetable.controller;

import com.dcc.timetable.domain.Coach;
import com.dcc.timetable.service.CoachService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;


import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {

    /*
    Define mapping for the app pages
    */

    @Autowired 
    private CoachService coachService;

    //Map to index
    @GetMapping("/")
    public String index(){

        log.info("Dentro de index");
        return "index";

    }

    //Map to config timetables
    @GetMapping({"/config", "/config/timetables"})
    public String config(Model model){
    
        model.addAttribute("section","timetables");
        log.info("Dentro de config");
        return "config";
            
    }


    //Map to config coaches
    @GetMapping("/config/coaches")
    public String configCoaches(Model model){
        var coaches = coachService.listCoaches();

        model.addAttribute("coaches", coaches);
        model.addAttribute("section","coaches");
        log.info("Dentro de config");
        return "config";
        
    }

    //Map to config timetables
    @GetMapping("/addnewcoach")
    public String addNewCoach(Model model){
    
        //model.addAttribute("section","coaches");
        log.info("Dentro de addNewCoach");
        return "addnewcoach";
            
    }

    @PostMapping("/config/savecoach")
    public String saveCoach(@Valid Coach coach, Errors errors){

        if(errors.hasErrors()){
            log.info("Errors founded!!!");
        }

        coachService.save(coach);
        return "redirect:/config/coaches";
    }
  
   


    
}
