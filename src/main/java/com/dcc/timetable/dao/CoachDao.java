package com.dcc.timetable.dao;

import com.dcc.timetable.domain.Coach;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CoachDao extends JpaRepository<Coach,Long>{
    
}
