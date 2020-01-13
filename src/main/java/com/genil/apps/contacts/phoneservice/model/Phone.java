package com.genil.apps.contacts.phoneservice.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Antony Genil Gregory on 1/12/2020 9:02 AM
 * For project : email-update
 **/
@Entity (name = "mc_phone")
@Data
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private String userName;
    private Boolean isPrimary;
    @Transient
    private String phoneServiceInstanceInfo;

}
