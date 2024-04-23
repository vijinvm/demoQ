package com.example.demoQ;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;
private long year;
@ManyToOne
@JoinColumn(name="user_id")
private User user;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getYear() {
	return year;
}
public void setYear(long year) {
	this.year = year;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
}
