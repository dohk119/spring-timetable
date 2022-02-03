package com.dcc.timetable.service;

import java.util.List;

import com.dcc.timetable.dao.ScheludeDao;
import com.dcc.timetable.domain.Schelude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScheludeServiceImpl implements ScheludeService {

    @Autowired
    private ScheludeDao scheludeDao;

    @Override
    @Transactional(readOnly = true)
    public List<Schelude> listScheludes() {

        return (List<Schelude>)scheludeDao.findAll();
    }

    @Override
    @Transactional()
    public void save(Schelude schelude) {
        
        scheludeDao.save(schelude);
        
    }

    @Override
    @Transactional
    public void delete(Schelude schelude) {

        scheludeDao.delete(schelude);
        
    }

    @Override
    @Transactional(readOnly = true)
    public Schelude findSchelude(Schelude schelude) {
    
        return scheludeDao.findById(schelude.getIdSchelude()).orElse(null);
    }
    
}
