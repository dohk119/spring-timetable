package com.dcc.timetable.domain;


import java.io.Serializable;
import java.sql.Time;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table(name = "scheludes")
public class Schelude implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSchelude;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private Time start_at;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private Time end_at;

    @NotNull
    private int day_of_week;

    @NotNull
    private int week;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_zone")
    private Zone zone;


    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_group")
    private Group group;

    /*
    Transforms time from input form into java.sql.Time
    The input type time is passed as string, this behavior generates a nullpointer
    so the schelude entity needs a java.sql.Time not a String.

    The solution is to use parametric polymorfism, adding a setter for each attribute
    that acepts a String instead of java.sql.Time. The parse the String into Time and update 
    the object value

    */
    public void setStart_at(String temp){

        temp = temp+":00";           
        this.start_at = Time.valueOf(temp);
    }

    public void setEnd_at(String temp){
        temp = temp+":00";
        this.end_at = Time.valueOf(temp);
    }

    //Returns the java.sql.Time as string with format HH:mm
    public String getStart_at(){
       
        return start_at.toString().substring(0, 5);
    }

    public String getEnd_at(){
        return this.end_at.toString().substring(0,5);
    }

}
