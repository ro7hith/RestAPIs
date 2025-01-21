package com.techwave.restapidemo.models.dao.Services;

import java.util.List;

import com.techwave.restapidemo.models.pojo.RestLogin;

public interface ILogin {
String InsertUser(RestLogin R);
int ValidateUser(String user,String  Password);
List<RestLogin> fetchAllUsers();
}
