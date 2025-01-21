package com.techwave.restapidemo.models.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.techwave.restapidemo.models.pojo.RestEmp;

@Repository
public interface IEmpRepository extends JpaRepository<RestEmp, Integer>{

}
