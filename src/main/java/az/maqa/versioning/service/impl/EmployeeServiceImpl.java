package az.maqa.versioning.service.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.maqa.versioning.entity.Employee;
import az.maqa.versioning.entity.EmployeeV1;
import az.maqa.versioning.entity.EmployeeV2;
import az.maqa.versioning.repository.EmployeeRepository;
import az.maqa.versioning.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeV1> getAllEmployeesV1() {
		List<Employee> employees = employeeRepository.findAllByActive(1);

		ModelMapper modelMapper = new ModelMapper();
		Type listType = new TypeToken<List<EmployeeV1>>() {
		}.getType();
		List<EmployeeV1> employeeV1 = modelMapper.map(employees, listType);

		return employeeV1;
	}

	@Override
	public List<EmployeeV2> getAllEmployeesV2() {
		List<Employee> employees = employeeRepository.findAllByActive(1);

		ModelMapper modelMapper = new ModelMapper();
		Type listType = new TypeToken<List<EmployeeV2>>() {
		}.getType();
		List<EmployeeV2> employeeV2 = modelMapper.map(employees, listType);

		return employeeV2;
	}

}
