package az.maqa.versioning.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import az.maqa.versioning.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	List<Employee> findAllByActive(Integer active);

}
