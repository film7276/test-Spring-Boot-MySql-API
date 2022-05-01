package com.example.test9.api;

import org.jetbrains.annotations.NotNull;
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
    public static Object aid;
    @Id
    private long id;
    private String name;
    public String tel;

    public Long getId() {return this.id;}
    public String getName() {return this.name;}
    public String getTel() {return this.tel;}
    public void setTel(String tel) {
        if (valphone(tel)) {
            this.tel = tel;
        }
    }
    /* ตรวจสอบเบอร์โทรที่รับมาว่าตรงเงื่อนไขหรือไม่ */
    public static boolean valphone(@NotNull String te) {
        return te.charAt(0) == '0' && te.length() == 10 && te.matches("[0-9]+");
    }
}
