package com.dcc.timetable.service;

import java.util.List;

import com.dcc.timetable.domain.Group;
import com.dcc.timetable.domain.Schedule;

public interface ScheduleService {

    public List<Schedule> listSchedules();

    public List<Schedule> listSchedules(Group group);

    public void save(Schedule schedule);

    public void delete(Schedule schedule);

    public Schedule findSchedule(Schedule schedule);
    
}
