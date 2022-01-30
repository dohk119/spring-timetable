package com.dcc.timetable.service;

import java.util.List;
import com.dcc.timetable.domain.Coach;


//Defines the methods for access and modificacion for coaches
public interface CoachService {

    public List<Coach> listCoaches();

    public void save(Coach coach);

    public void delete(Coach coach);

    public Coach findCoach(Coach coach);


    
}
