package com.dcc.timetable.dao;

import java.util.List;

import com.dcc.timetable.domain.Group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface GroupDao extends JpaRepository<Group,Long>{

    //Solve N + 1 on select
    //@Query("select c from Group c join fetch c.location")
    @Query("select c from Group c left join  c.location")

    List<Group> findAll();


    @Query("select c from Group c left join  c.location where c.location.week = :#{#week}")
    List<Group> findAll(@Param("week")int week);


}
