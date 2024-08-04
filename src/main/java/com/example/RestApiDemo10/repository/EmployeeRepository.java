package com.example.RestApiDemo10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RestApiDemo10.model.EmployeeModel;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel,Long> {

}
