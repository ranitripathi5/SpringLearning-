package net.javaguides.springbootbackend.repository;

import net.javaguides.springbootbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// extending jpa repo will auto generate @Repository annotation here
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
