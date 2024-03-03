package com.example.jpastudy.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "TB_MEMBER")
@Entity
@IdClass(MemberPK.class)
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private int memberId;

    @Id
    @Column(name = "PHONE")
    private int phone;

    @Column(name = "NAME")
    private String name;
}
