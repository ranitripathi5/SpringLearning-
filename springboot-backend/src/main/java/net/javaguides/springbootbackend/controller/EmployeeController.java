package net.javaguides.springbootbackend.controller;

import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    //build create employee REST API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
    }

    //build get all Employee REST API
    @GetMapping
    public List<Employee>getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //return Specific employee by id to the client
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable("id") long employeeID){
        return new ResponseEntity<Employee>(employeeService.getmployeeByID(employeeID),HttpStatus.OK);
    }

    //Build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
    }

    //DeleteEmployee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id")long id){
        employeeService.deleteEmployee(id);

        return new ResponseEntity<String>("Employee deleted bete !",HttpStatus.OK);
    }
}
