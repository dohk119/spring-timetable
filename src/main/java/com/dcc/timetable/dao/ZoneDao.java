package com.dcc.timetable.dao;

import com.dcc.timetable.domain.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneDao extends JpaRepository<Zone,Long>{
    
}
