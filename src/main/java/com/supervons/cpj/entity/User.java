package com.supervons.cpj.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "user_info")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private String id;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "pass_word")
    private String passWord;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_sex")
    private String userSex;

    @Column(name = "user_address")
    private String userAddress;

    @Column(name = "user_cellphone")
    private String userCellPhone;

}
