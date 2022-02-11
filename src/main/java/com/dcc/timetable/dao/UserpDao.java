package com.dcc.timetable.dao;

import com.dcc.timetable.domain.Userp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserpDao extends JpaRepository<Userp, Long> {

    Userp findByUsername(String username);
    
}
