package com.dcc.timetable.service;

import java.util.List;

import com.dcc.timetable.domain.Zone;

public interface ZoneService {

    public List<Zone> listZones();

    public void save(Zone zone);

    public void delete(Zone zone);

    public Zone findZone(Zone zone);
    
    
}
