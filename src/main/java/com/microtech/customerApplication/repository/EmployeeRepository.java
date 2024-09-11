package com.microtech.customerApplication.repository;

import com.microtech.customerApplication.entity.Customer;
import com.microtech.customerApplication.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


    public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    }

