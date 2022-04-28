package com.example.test9.api;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
/* ชื่อ Table ใน MySQL  "uesrinfo" */
@Table(
        name = "userinfo"
)
@EntityListeners({AuditingEntityListener.class})
public class user {
    @Id
    private long id;
    private String name;
    private String tel;

    public Long getId() {return this.id;}
    public String getName() {return this.name;}
    public String getTel() {return this.tel;}
}
