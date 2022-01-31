package com.dcc.timetable.dao;

import com.dcc.timetable.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupDao extends JpaRepository<Group,Long>{
    
}
