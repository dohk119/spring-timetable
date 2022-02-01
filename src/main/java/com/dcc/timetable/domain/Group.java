package com.dcc.timetable.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;

@Data
@Entity
@Table(name = "ggroups")
public class Group implements Serializable{

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGroup;

    @NotEmpty
    private String name;

    //private Integer id_location;

    //@ManyToOne()
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_location", insertable = false, updatable = false)
    //@JoinColumn(name = "id_location", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Location location;
/*
    public String getLocation(){
        if(location == null)
            return "Vacio!!!";
        else 
            return location.getName();
    }
    */
}
