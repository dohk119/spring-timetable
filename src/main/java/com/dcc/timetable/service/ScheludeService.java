package com.dcc.timetable.service;

import java.util.List;

import com.dcc.timetable.domain.Schelude;

public interface ScheludeService {

    public List<Schelude> listScheludes();

    public void save(Schelude schelude);

    public void delete(Schelude schelude);

    public Schelude findSchelude(Schelude schelude);
    
}
