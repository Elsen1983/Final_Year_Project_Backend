package com.fyp.SpringBootBackend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="testdata_all")
public class DatabaseAllBasic implements Serializable {
    @Id
    @Column(name="event_id")
    private int id;

    @Column(name="user")
    private String user;

    @Column(name="timestamp")
    private String timestamp;

    @Column(name="type")
    private String type;

    @Transient
    private String token;

}
