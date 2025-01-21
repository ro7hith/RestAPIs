package com.techwave.restapidemo.models.pojo;

import org.hibernate.annotations.Check;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
@Check(name="chk_utype",constraints="usertype='associate' or usertype='manager'")
public class RestLogin {
@Id
@Column(length=25)
private String username;
@Column(length=60,nullable=false)
private String password;
@Column(length=10,nullable=false)
private String usertype;
public RestLogin() {
	super();
}
public RestLogin(String username, String password, String usertype) {
	super();
	this.username = username;
	this.password = password;
	this.usertype = usertype;
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
public String getUsertype() {
	return usertype;
}
public void setUsertype(String usertype) {
	this.usertype = usertype;
}

}
