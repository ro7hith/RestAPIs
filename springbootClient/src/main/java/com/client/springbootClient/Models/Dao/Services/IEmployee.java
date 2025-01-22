package com.client.springbootClient.Models.Dao.Services;

import java.util.List;

import com.client.springbootClient.Models.Pojo.Employee;

public interface IEmployee {
Employee[] GetAllEmps();
Employee GetById(int empno);
String Insert(Employee E);
Employee Update(Employee E);
void Delete(int empno);


}
