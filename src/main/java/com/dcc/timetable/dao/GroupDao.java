package com.dcc.timetable.dao;

import java.util.List;
import java.util.Optional;

import com.dcc.timetable.domain.Group;
//import com.dcc.timetable.domain.Location;

import org.springframework.data.jpa.repository.EntityGraph;
//import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.stereotype.Repository;


public interface GroupDao extends JpaRepository<Group,Long>{

    //Solve N + 1 on select
    //@Query("select c from Group c join fetch c.location")
    @Query("select c from Group c left join  c.location")

    List<Group> findAll();

}
