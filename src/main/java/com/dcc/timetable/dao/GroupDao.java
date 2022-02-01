package com.dcc.timetable.dao;

import java.util.List;

import com.dcc.timetable.domain.Group;
//import com.dcc.timetable.domain.Location;

//import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupDao extends JpaRepository<Group,Long>{
/*
    @Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto(d.location_name, e.name) "
    + "FROM locations d INNER JOIN d.ggroups e")
List<DeptEmpDto> fetchEmpDeptDataInnerJoin();
   */ 

    //List<Location> findByLocation(Location location, Sort sort);

}
