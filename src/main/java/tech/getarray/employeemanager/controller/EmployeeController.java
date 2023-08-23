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
        return ResponseEntity.ok(employeeService.findAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}
