package az.maqa.versioning.service;

import java.util.List;

import az.maqa.versioning.entity.EmployeeV1;
import az.maqa.versioning.entity.EmployeeV2;

public interface EmployeeService {

	List<EmployeeV1> getAllEmployeesV1();

	List<EmployeeV2> getAllEmployeesV2();
}
