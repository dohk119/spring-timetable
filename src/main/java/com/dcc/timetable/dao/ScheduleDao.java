package com.dcc.timetable.dao;

import java.util.List;

import com.dcc.timetable.domain.Schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScheduleDao extends JpaRepository<Schedule,Long>{

    //Prevent N+1 queries
    @Query("select c from Schedule c join fetch c.zone join fetch c.group left join c.coach")
    List<Schedule> findAll();

    //    @Query("select c from Schelude c join fetch c.zone join fetch c.group left join c.coach where c.group.idGroup = :#{#idGroup}")

    @Query("select c from Schedule c join fetch c.zone join fetch c.group left join c.coach where c.group.idGroup = :#{#idGroup}")
    List<Schedule> findAll(@Param("idGroup")Long idGroup);

    //List<Schedule> findAllByOrderByZoneAsc();

    
}
