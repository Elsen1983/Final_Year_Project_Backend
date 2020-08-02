package com.fyp.SpringBootBackend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="testdata_validation")
public class DatabaseValidation implements Serializable {

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

    @Column(name="bank_name")
    private String bank_name;

    @Column(name="pipe_name")
    private String pipe_name;

    @Column(name="is_schemaerrors")
    private Integer is_schemaerrors;

    @Column(name="is_validationerrors")
    private Integer is_validationerrors;

    @Column(name="size_of_file")
    private Integer size_of_file;

    @Column(name="nb_ocl_errors")
    private Integer nb_ocl_errors;

    @Column(name="nb_ocl_notices")
    private Integer nb_ocl_notices;

    @Column(name="nb_ocl_infos")
    private Integer nb_ocl_infos;

    @Transient
    private String token;

}
