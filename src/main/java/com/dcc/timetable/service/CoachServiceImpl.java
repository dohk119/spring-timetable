package com.dcc.timetable.service;

import java.util.List;


import com.dcc.timetable.dao.CoachDao;
import com.dcc.timetable.domain.Coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CoachServiceImpl implements CoachService{

    @Autowired
    private CoachDao coachDao;

    @Override
    @Transactional(readOnly = true)
    public List<Coach> listCoaches() {

        return (List<Coach>)coachDao.findAll();

    }

    @Override
    @Transactional()
    public void save(Coach coach) {
        
        coachDao.save(coach);

    }

    @Override
    @Transactional()
    public void delete(Coach coach) {
        
        coachDao.delete(coach);
        
    }

    @Override
    @Transactional(readOnly = true)
    public Coach findCoach(Coach coach) {

        return coachDao.findById(coach.getIdCoach()).orElse(null);
        
    }
    
}
