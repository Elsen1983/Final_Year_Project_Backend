package com.fyp.SpringBootBackend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="testdata_editing")
public class DatabaseEditing implements Serializable {

    @Id
    @Column(name="event_id")
    private Integer event_id;

    @Column(name="timestamp")
    private String timestamp;

    @Column(name="type")
    private String type;

    @Column(name="username")
    private String username;

    @Column(name="company_name")
    private String company_name;

    @Column(name="user_company_name")
    private String user_company_name;

//    @Column(name="severity")
//    private Integer severity;
//
//    @Column(name="channel")
//    private Integer channel;
//
//    @Column(name="is_companyadmin")
//    private Integer is_companyadmin;
//
//    @Column(name="is_superadmin")
//    private Integer is_superadmin;

    @Column(name="description")
    private String description;

    @Column(name="target")
    private String target;

    @Column(name="subtarget")
    private String subtarget;

    @Column(name="subtype")
    private String subtype;

    @Column(name="values")
    private String values;

    @Column(name="is_successful")
    private Integer is_successful;

    @Transient
    private String token;
}
