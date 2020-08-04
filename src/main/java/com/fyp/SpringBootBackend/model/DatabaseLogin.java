package com.fyp.SpringBootBackend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="testdata_login")
public class DatabaseLogin implements Serializable {
    @Id
    @Column(name="event_id")
    private Integer event_id;

    @Column(name="timestamp")
    private String timestamp;

    @Column(name="type")
    private String type;

    @Column(name="user")
    private String user;

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

    @Transient
    private String token;
}
