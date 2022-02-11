package com.dcc.timetable.dao;

import java.util.List;

import com.dcc.timetable.domain.Group;
import com.dcc.timetable.domain.Schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScheduleDao extends JpaRepository<Schedule,Long>{

    //Prevent N+1 queries
    @Query("select c from Schedule c left join  c.zone join fetch c.group left join c.coach")
    List<Schedule> findAll();

    //    @Query("select c from Schelude c join fetch c.zone join fetch c.group left join c.coach where c.group.idGroup = :#{#idGroup}")

    @Query("select c from Schedule c join fetch c.zone join fetch c.group left join c.coach where c.group.idGroup = :#{#idGroup}")
    List<Schedule> findAll(@Param("idGroup")Long idGroup);

    List<Schedule> findByGroupOrderByWeek(Group group);

//    @Query("select c from Schedule c join fetch c.zone join fetch c.group left join c.coach")
    @Query("select c from Schedule c join fetch c.zone join fetch c.group order by c.day_of_week asc, c.start asc")
    List<Schedule> findByGroupOrderByStart(Group group);

    List<Schedule> findByGroupAndWeek(Group group, int week);

    
}
