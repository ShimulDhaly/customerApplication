package com.microtech.customerApplication.controller;

import com.microtech.customerApplication.entity.Employee;
import com.microtech.customerApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

  @PostMapping()
    public ResponseEntity<String> insertEmployee(@RequestBody Employee employee){
      employeeRepository.save(employee);
      return new ResponseEntity("employee added successfully", HttpStatus.CREATED);
  }


  @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id){
      Employee employee = employeeRepository.findById(id).orElse(null);
      if(employee!=null){
          return ResponseEntity.ok(employee);
      }else{
          return ResponseEntity.notFound().build();

      }
  }
  @GetMapping("/getall")
   public List<Employee> getAllEmployee(){
      return employeeRepository.findAll();
  }

  @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,@RequestBody Employee updateemployee){
   Employee employee=employeeRepository.findById(id).orElse(null);
        if(employee!=null){
            employee.setName(updateemployee.getName());
            employee.setAddress(updateemployee.getAddress());
            employee.setEmail(updateemployee.getEmail());
            employee.setGender(updateemployee.getGender());
            employee.setSalary(updateemployee.getSalary());
            employeeRepository.save(employee);
            return ResponseEntity.ok(employee);
        }else {
            return ResponseEntity.noContent().build();
        }

  }
  @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteById(@PathVariable Integer id){
      if (employeeRepository.existsById(id)) {
          employeeRepository.deleteById(id);
          return ResponseEntity.noContent().build();
      }else{
          return ResponseEntity.notFound().build();
      }
  }
  @DeleteMapping("/all")
    public ResponseEntity<Employee> deleteAllEmployee(){
      employeeRepository.deleteAll();
      return ResponseEntity.noContent().build();
  }
}
