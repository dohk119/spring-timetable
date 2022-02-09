package com.dcc.timetable.service;

import java.util.List;

import com.dcc.timetable.dao.ScheduleDao;
import com.dcc.timetable.domain.Group;
import com.dcc.timetable.domain.Schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;

    @Override
    @Transactional(readOnly = true)
    public List<Schedule> listSchedules() {

        return (List<Schedule>)scheduleDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Schedule> listSchedules(Group group) {

        //return (List<Schedule>)scheduleDao.findAll(group.getIdGroup());
        return (List<Schedule>) scheduleDao.findByGroupOrderByStart(group);
    }

    @Override
    @Transactional()
    public void save(Schedule schedule) {
        
        scheduleDao.save(schedule);
        
    }

    @Override
    @Transactional
    public void delete(Schedule schedule) {

        scheduleDao.delete(schedule);
        
    }

    @Override
    @Transactional(readOnly = true)
    public Schedule findSchedule(Schedule schedule) {
    
        return scheduleDao.findById(schedule.getIdSchedule()).orElse(null);
    }
    
}
