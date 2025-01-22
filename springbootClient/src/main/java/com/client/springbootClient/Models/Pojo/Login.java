package com.client.springbootClient.Models.Pojo;

import jakarta.validation.constraints.NotBlank;

public class Login {

	@NotBlank(message="required")
	private String username;
	@NotBlank(message="required")
	private String password;
	@NotBlank(message="required")
	private String usertype;
	public Login(@NotBlank(message = "required") String username, @NotBlank(message = "required") String password,
			@NotBlank(message = "required") String usertype) {
		super();
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}
	public Login() {
		super();
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
