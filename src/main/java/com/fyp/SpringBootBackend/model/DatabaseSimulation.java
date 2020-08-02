package com.fyp.SpringBootBackend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="testdata_simulation")
public class DatabaseSimulation implements Serializable {

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

    @Column(name="severity")
    private Integer severity;

    @Column(name="channel")
    private Integer channel;

    @Column(name="is_companyadmin")
    private Integer is_companyadmin;

    @Column(name="is_superadmin")
    private Integer is_superadmin;

    @Column(name="description")
    private String description;

    @Column(name="simulation_type")
    private String simulation_type;

    @Column(name="simulation_msg_tp")
    private String simulation_msg_tp;

    @Column(name="bank")
    private String bank;

    @Column(name="bank_sub")
    private String bank_sub;

    @Column(name="nb_of_txs")
    private String nb_of_txs;

    @Column(name="is_ultmtdbtr")
    private String is_ultmtdbtr;

    @Column(name="is_ultmtcdtr")
    private String is_ultmtcdtr;

    @Column(name="is_endtoendid")
    private String is_endtoendid;

    @Column(name="is_aos2")
    private String is_aos2;

    @Column(name="is_ref")
    private String is_ref;

    @Column(name="is_successful")
    private Integer is_successful;

    @Transient
    private String token;
}
