package com.dcc.timetable.service;

import java.util.List;
import com.dcc.timetable.domain.Location;

public interface LocationService {

    public List<Location> listLocations();

    public void save(Location location);

    public void delete(Location location);

    public Location findLocation(Location location);

    
}
