package com.dcc.timetable.service;

import java.util.List;

import com.dcc.timetable.dao.LocationDao;
import com.dcc.timetable.domain.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationDao locationDao;

    @Override
    @Transactional(readOnly = true)
    public List<Location> listLocations() {
        
        return (List<Location>)locationDao.findAll();
    }

    @Override
    @Transactional()
    public void save(Location location) {

        locationDao.save(location);
        
    }

    @Override
    @Transactional()
    public void delete(Location location) {

        locationDao.delete(location);
        
    }

    @Override
    @Transactional(readOnly = true)
    public Location findLocation(Location location) {
        
        return locationDao.findById(location.getIdLocation()).orElse(null);

    }
    
}
