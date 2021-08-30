package tech.getarrays.employmanager.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employmanager.model.Employee;
import tech.getarrays.employmanager.service.EmployeeService;


import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    @Autowired
    EmployeeService empolyeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = empolyeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Long id) {

        Employee employee = empolyeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);


    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

        Employee newEmployee = empolyeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);


    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = empolyeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {

        empolyeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);


    }


}
