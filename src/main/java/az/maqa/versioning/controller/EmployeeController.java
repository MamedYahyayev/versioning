package az.maqa.versioning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.maqa.versioning.entity.EmployeeV1;
import az.maqa.versioning.entity.EmployeeV2;
import az.maqa.versioning.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// Uri Versioning

	@GetMapping({ "/v1.0", "/v1.1" })
	public List<EmployeeV1> getEmployeesV1() {
		List<EmployeeV1> response = employeeService.getAllEmployeesV1();
		return response;
	}

	@GetMapping({ "/v2.0", "/v2.1" })
	public List<EmployeeV2> getEmployeesV2() {
		List<EmployeeV2> response = employeeService.getAllEmployeesV2();
		return response;
	}

	// Param Versioning

	@GetMapping(value = "/param", params = "v=1")
	public List<EmployeeV1> getEmployeesV1Param() {
		List<EmployeeV1> response = employeeService.getAllEmployeesV1();
		return response;
	}

	@GetMapping(value = "/param", params = "v=2")
	public List<EmployeeV2> getEmployeesV2Param() {
		List<EmployeeV2> response = employeeService.getAllEmployeesV2();
		return response;
	}

	// Header Versioning
	@GetMapping(value = "/header", headers = "X_EMP_VERSION=1")
	public List<EmployeeV1> getEmployeesV1Header() {
		List<EmployeeV1> response = employeeService.getAllEmployeesV1();
		return response;
	}

	@GetMapping(value = "/header", headers = "X_EMP_VERSION=2")
	public List<EmployeeV2> getEmployeesV2Header() {
		List<EmployeeV2> response = employeeService.getAllEmployeesV2();
		return response;
	}

	// Media Type Versioning
	@GetMapping(value = "/media", produces = "application/emp.version-v1+json")
	public List<EmployeeV1> getEmployeesV1Media() {
		List<EmployeeV1> response = employeeService.getAllEmployeesV1();
		return response;
	}

	@GetMapping(value = "/media", produces = "application/emp.version-v2+json")
	public List<EmployeeV2> getEmployeesV2Media() {
		List<EmployeeV2> response = employeeService.getAllEmployeesV2();
		return response;
	}

}
