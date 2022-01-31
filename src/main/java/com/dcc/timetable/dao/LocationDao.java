package com.dcc.timetable.dao;

import com.dcc.timetable.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationDao extends JpaRepository<Location,Long>{
    
}
