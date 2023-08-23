package tech.getarray.employeemanager.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarray.employeemanager.exception.UserNotFoundException;
import tech.getarray.employeemanager.model.Employee;
import tech.getarray.employeemanager.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Data
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return (employeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + id + "is not found")));
    }
    public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
    }
}
