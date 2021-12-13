package com.itgate.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "friend_ship")
public class FriendShip {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id_1")
    private int firstUserId;

    @Column(name = "user_id_2")
    private int secondUserId;

    @Column(name = "status")
    private int status;

    @Column(name = "action_user_id")
    private int actionUserId;

    public FriendShip() {
    }

    public FriendShip(int firstUserId, int secondUserId, int status, int actionUserId) {
        this.firstUserId = firstUserId;
        this.secondUserId = secondUserId;
        this.status = status;
        this.actionUserId = actionUserId;
    }

    public FriendShip(int id, int firstUserId, int secondUserId, int status, int actionUserId) {
        this.id = id;
        this.firstUserId = firstUserId;
        this.secondUserId = secondUserId;
        this.status = status;
        this.actionUserId = actionUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFirstUserId() {
        return firstUserId;
    }

    public void setFirstUserId(int firstUserId) {
        this.firstUserId = firstUserId;
    }

    public int getSecondUserId() {
        return secondUserId;
    }

    public void setSecondUserId(int secondUserId) {
        this.secondUserId = secondUserId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getActionUserId() {
        return actionUserId;
    }

    public void setActionUserId(int actionUserId) {
        this.actionUserId = actionUserId;
    }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

