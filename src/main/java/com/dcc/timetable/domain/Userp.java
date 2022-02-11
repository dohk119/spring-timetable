package com.dcc.timetable.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class Userp implements Serializable{

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
    
    @OneToMany
    @JoinColumn(name="id_user")
    private List<Role> roles;
}
