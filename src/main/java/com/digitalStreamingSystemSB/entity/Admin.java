package com.digitalStreamingSystemSB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Model mapped to a row in the table. [ORM]
@Entity
// Admin > ADMIN
@Table(name="ADMIN")

public class Admin {
    //	Uniqueness
    @Id
//	Auto gen Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//	id > ADMIN_ID
    @Column(name="ADMIN_ID")
    private int admin_id;
    @Column(name="NAME", nullable = false)
    private String name;
    @Column(name="PHONE", nullable = false)
    private String phone;
    @Column(name="USERNAME", nullable = false)
    private String username;
    @Column(name="PASSWORD", nullable = false)
    private String password;
    @Column(name="EMAIL", nullable = false)
    private String email;

    public Admin(int admin_id, String name, String phone, String username, String password, String email) {
        this.admin_id = admin_id;
        this.name = name;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Admin() {
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}
