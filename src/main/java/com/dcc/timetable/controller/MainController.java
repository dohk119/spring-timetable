package com.dcc.timetable.controller;

import com.dcc.timetable.dao.CoachDao;
import com.dcc.timetable.domain.*;
import com.dcc.timetable.service.CoachService;
import com.dcc.timetable.service.GroupService;
import com.dcc.timetable.service.LocationService;
import com.dcc.timetable.service.ZoneService;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
public class MainController {

    /*
    Define mapping for the app pages
    */

    @Autowired 
    private CoachService coachService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private ZoneService zoneService;

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

    @GetMapping("/config/coaches/{idCoach}")
    public String editCoach(Coach coach, Model model) {
        coach = coachService.findCoach(coach);
        model.addAttribute("coach", coach);
        return "modifycoach";
    }


    @PostMapping("/config/savecoach")
    public String saveCoach(@Valid Coach coach, Errors errors){

        if(errors.hasErrors()){
            log.info("Errors founded!!!");
        }

        coachService.save(coach);
        return "redirect:/config/coaches";
    }


    @GetMapping("/config/coaches/delete/{idCoach}")
    public String deleteCoach(Coach coach){

        coachService.delete(coach);
        return "redirect:/config/coaches";

    }

    //Groups mapping

    @GetMapping("/config/groups")
    public String configGroups(Model model){

        var locations = locationService.listLocations();    //Load locations for the select in the modal add form
        var groups = groupService.listGroups();
        model.addAttribute("locations", locations);
        model.addAttribute("groups", groups);
        model.addAttribute("section","groups");     //Used for section loading
        log.info("Dentro de Groups");
        return "config";
        
    }

    @PostMapping("/config/savegroup")
    public String saveGroup(@Valid Group group, Errors errors){

        if(errors.hasErrors()){
            log.info("Errors founded!!!");
        }

        groupService.save(group);
        return "redirect:/config/groups";
    }

    @GetMapping("/config/groups/{idGroup}")
    public String editCoach(Group group, Model model) {
        var locations = locationService.listLocations();
        group = groupService.findGroup(group);
        model.addAttribute("locations", locations);
        model.addAttribute("group", group);
        model.addAttribute("section","editgroup");     //Used for section loading
        return "config";
    }

    @GetMapping("/config/groups/delete/{idGroup}")
    public String deleteCoach(Group group){

        groupService.delete(group);
        return "redirect:/config/groups";

    }
  
   //Locations 

   @GetMapping("/config/locations")
   public String configLocations(Model model){
       var locations = locationService.listLocations();

       model.addAttribute("locations", locations);
       model.addAttribute("section","locations");     //Used for section loading
       log.info("Dentro de Locations");
       return "config";
       
   }

   @GetMapping("/config/locations/{idLocation}")
   public String editLocation(Location location, Model model){

        location = locationService.findLocation(location);
        model.addAttribute("location", location);
        model.addAttribute("section", "editlocation");
        return "config";
   }

   @PostMapping("/config/savelocation")
    public String saveGroup(@Valid Location location, Errors errors){

        if(errors.hasErrors()){
            log.info("Errors founded!!!");
        }

        locationService.save(location);
        return "redirect:/config/locations";
    }

    @GetMapping("/config/locations/delete/{idLocation}")
    public String deleteLocation(Location location){

        locationService.delete(location);
        return "redirect:/config/locations";

    }

    //Zones

    @GetMapping("/config/zones")
    public String configZones(Model model){
        var zones = zoneService.listZones();

        model.addAttribute("zones", zones);
        model.addAttribute("section","zones");     //Used for section loading
        log.info("Dentro de Zones");
        return "config";
       
    }

    @GetMapping("/config/zones/{idZone}")
    public String editZone(Zone zone, Model model){

        zone = zoneService.findZone(zone);
        model.addAttribute("zone", zone);
        model.addAttribute("section", "editzone");
        return "config";
    }

   @PostMapping("/config/savezone")
    public String saveZone(@Valid Zone zone, Errors errors){

        if(errors.hasErrors()){
            log.info("Errors founded!!!");
        }

        zoneService.save(zone);
        return "redirect:/config/zones";
    }

    @GetMapping("/config/zones/delete/{idZone}")
    public String deleteZone(Zone zone){

        zoneService.delete(zone);
        return "redirect:/config/zones";

    }

    
}
