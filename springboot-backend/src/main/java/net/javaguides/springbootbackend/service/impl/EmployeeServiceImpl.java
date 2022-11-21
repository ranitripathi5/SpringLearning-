package net.javaguides.springbootbackend.service.impl;

import net.javaguides.springbootbackend.exception.ResourceNotFound;
import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRepository;
import net.javaguides.springbootbackend.service.EmployeeService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//we dont need to put @Transaction annotation cause spring data Jpa internally provides transaction to all of its methods
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;


    // there isn't a need of using @Autowired annotation because if a class, which is configured as a spring bean,
    // has only one constructor, @Autowired can be omitted and spring will use that constructor
    // and inject all necessary dependencies
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getmployeeByID(long id) {
        Optional<Employee> employee=employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }else{
            throw new ResourceNotFound("Employee","id",id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
         // check if the employee with id given is existing or not?
        Employee ExistEmployee=employeeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("Employee","id",id));
        ExistEmployee.setFirstName(employee.getFirstName());
        ExistEmployee.setLastName(employee.getLastName());//Name());
        ExistEmployee.setEmail(employee.getEmail());

        // saving it to db
        employeeRepository.save(ExistEmployee);
        return ExistEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        //check existence of the employee given to be deleted
        employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFound("Employee","id",id));
        employeeRepository.deleteById(id);
    }
}
