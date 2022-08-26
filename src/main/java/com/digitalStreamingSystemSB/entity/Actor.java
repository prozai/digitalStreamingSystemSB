package com.digitalStreamingSystemSB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Model mapped to a row in the table. [ORM]
@Entity
// Actors > ACTORS
@Table(name="ACTORS")
public class Actor {
    //	Uniqueness
    @Id
//	Auto gen Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//	actorId > ACTOR_ID
    @Column(name="ACTOR_ID")
    private int actorId;
    @Column(name="FIRST_NAME", nullable = false)
    private String firstName;
    @Column(name="LAST_NAME", nullable = false)
    private String lastName;
    @Column(name="GENDER", nullable = false)
    private String gender;
    @Column(name="AGE", nullable = false)
    private int age;

    public Actor() {
    }
    public Actor(int actorId, String firstName, String lastName, String gender, int age) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
