package com.dcc.timetable.domain;


import java.io.Serializable;
import java.sql.Time;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "schedules")
public class Schedule implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSchedule;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private Time start;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private Time end;

    @NotNull
    private int day_of_week;

    @NotNull
    private int week;

    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_zone")
    private Zone zone;


    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_group")
    private Group group;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_coach")
    private Coach coach;


    /*
    Transforms time from input form into java.sql.Time
    The input type time is passed as string, this behavior generates a nullpointer
    so the schelude entity needs a java.sql.Time not a String.

    The solution is to use parametric polymorfism, adding a setter for each attribute
    that acepts a String instead of java.sql.Time. The parse the String into Time and update 
    the object value

    */
    public void setStart(String temp){

        temp = temp+":00";           
        this.start = Time.valueOf(temp);
    }

    public void setEnd(String temp){
        temp = temp+":00";
        this.end = Time.valueOf(temp);
    }

    //Returns the java.sql.Time as string with format HH:mm
    public String getStart(){
       
        return start.toString().substring(0, 5);
    }

    public String getEnd(){
        return this.end.toString().substring(0,5);
    }


}
