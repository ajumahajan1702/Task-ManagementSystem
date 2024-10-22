package com.example.demo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String details;
    @ManyToOne
	User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", details=" + details + ", user=" + user + "]";
	}
	public Task(int id, String details, User user) {
		super();
		this.id = id;
		this.details = details;
		this.user = user;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
    

}
