package tech.getarray.employeemanager.controller;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarray.employeemanager.model.Employee;
import tech.getarray.employeemanager.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@Data
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
//        return ResponseEntity.ok(employeeService.findAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable("id") Long id){
        Optional<Employee> employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
//        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
//        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmploye = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmploye, HttpStatus.OK);
//        return ResponseEntity.ok(employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id){
//        return ResponseEntity.ok(employeeService.deleteEmployee(id);
//    }
    
}
