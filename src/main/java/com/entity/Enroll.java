package com.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="ENROLL")
public class Enroll {
    
    @Id
    @Column(name="ENROLL_ID")
    private int enroll_id;
    
    @ManyToOne
    @JoinColumn(name="CHALLENGE_ID")
    private Challenge challenge;
    
    @Column(name="USER_ID")
    private int user_id;
    
    
public Enroll() {
}
public Enroll(int enroll_id, int user_id) {
    this.enroll_id = enroll_id;
    this.user_id = user_id;
}
public int getEnroll_id() {
    return enroll_id;
}
public void setEnroll_id(int enroll_id) {
    this.enroll_id = enroll_id;
}
public Challenge getChallenge() {
    return challenge;
}
public void setChallenge(Challenge challenge) {
    this.challenge = challenge;
}
public int getUser_id() {
    return user_id;
}
public void setUser_id(int user_id) {
    this.user_id = user_id;
}
}