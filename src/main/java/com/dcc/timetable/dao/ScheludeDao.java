package com.dcc.timetable.dao;

import java.util.List;

import com.dcc.timetable.domain.Schelude;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScheludeDao extends JpaRepository<Schelude,Long>{

    //Prevent N+1 queries
    @Query("select c from Schelude c join fetch c.zone join fetch c.group")
    List<Schelude> findAll();

    
}
