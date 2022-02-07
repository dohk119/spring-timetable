package com.dcc.timetable.service;

import java.util.List;
import com.dcc.timetable.domain.Group;

public interface GroupService {

    public List<Group> listGroups();

    public List<Group> listGroups(int week);

    public void save(Group group);

    public void delete(Group group);

    public Group findGroup(Group group);
    
}
