package com.dcc.timetable.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Fetch;

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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_location")
    private Location location;

}
