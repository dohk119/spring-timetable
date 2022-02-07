package com.dcc.timetable.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

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

    @NotNull
    @NumberFormat
    @Column(name = "week")
    private int week;




    public String getName(){
        return name;
    }

    public String toString(){
        return name;
    }
}
