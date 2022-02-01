package com.dcc.timetable.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "locations")
public class Location implements Serializable{

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocation;

    @NotEmpty
    @Column(name = "location_name")
    private String name;
/*
	@OneToMany(targetEntity = Group.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<Group> groups;
    */

    public String getName(){
        return name;
    }

    public String toString(){
        return name;
    }
}
