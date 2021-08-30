package tech.getarrays.employmanager.service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import tech.getarrays.employmanager.exception.UserNotFoundException;
import tech.getarrays.employmanager.model.Employee;
import tech.getarrays.employmanager.repo.EmployeeRepo;

import javax.transaction.Transactional;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public  Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public  List<Employee> findAllEmployees(){
        return employeeRepo.findAll();

    }
    public  Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);

    }
    public  Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("USer by id"+id+"was not found"));

    }

    public  void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);


    }
}
