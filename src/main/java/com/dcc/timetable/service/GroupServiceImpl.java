package com.dcc.timetable.service;

import java.util.List;

import com.dcc.timetable.dao.GroupDao;
import com.dcc.timetable.domain.Group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupDao groupDao;

    @Override
    @Transactional(readOnly = true)
    public List<Group> listGroups() {
       
        return (List<Group>)groupDao.findAll();

    }

    @Override
    @Transactional(readOnly = true)
    public List<Group> listGroups(int week) {
       
        return (List<Group>)groupDao.findAll(week);

    }

    @Override
    @Transactional()
    public void save(Group group) {

        groupDao.save(group);
        
    }

    @Override
    @Transactional()
    public void delete(Group group) {

        groupDao.delete(group);

    }

    @Override
    @Transactional(readOnly = true)
    public Group findGroup(Group group) {
        
        return groupDao.findById(group.getIdGroup()).orElse(null);
    }
    
}
