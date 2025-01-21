package com.techwave.restapidemo.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techwave.restapidemo.models.pojo.RestLogin;

public interface ILoginRepository extends JpaRepository<RestLogin, String>{

}
