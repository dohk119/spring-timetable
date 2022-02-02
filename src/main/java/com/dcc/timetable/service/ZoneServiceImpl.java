package com.dcc.timetable.service;

import java.util.List;

import com.dcc.timetable.dao.ZoneDao;
import com.dcc.timetable.domain.Zone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    private ZoneDao zoneDao;

    @Override
    @Transactional(readOnly = true)
    public List<Zone> listZones() {

        return (List<Zone>)zoneDao.findAll();
    }

    @Override
    @Transactional()
    public void save(Zone zone) {

        zoneDao.save(zone);
        
    }

    @Override
    @Transactional()
    public void delete(Zone zone) {

        zoneDao.delete(zone);
        
    }

    @Override
    @Transactional()
    public Zone findZone(Zone zone) {

        return zoneDao.findById(zone.getIdZone()).orElse(null);
    }

    
}
