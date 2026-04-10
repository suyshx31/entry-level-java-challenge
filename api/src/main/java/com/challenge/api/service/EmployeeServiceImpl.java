package com.challenge.api.service;

import com.challenge.api.model.CreateEmployeeInput;
import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeModel;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<UUID, Employee> store = new ConcurrentHashMap<>();

    public EmployeeServiceImpl() {
        seed("Hussaina", "Bandookwala", 92000, 26, "Software Engineer", "hussaina.bandookwala@bmw.com");
        seed("Ashish", "Vishwakarma", 115000, 40, "Engineering Manager", "ashish.vishwakarma@bmw.com");
        seed("Nilesh", "Salunke", 78000, 30, "QA Analyst", "nilesh.salunke@bmw.com");
    }

    private void seed(String first, String last, int salary, int age, String title, String email) {
        EmployeeModel employee = new EmployeeModel();
        employee.setUuid(UUID.randomUUID());
        employee.setFirstName(first);
        employee.setLastName(last);
        employee.setSalary(salary);
        employee.setAge(age);
        employee.setJobTitle(title);
        employee.setEmail(email);
        employee.setContractHireDate(Instant.now());
        store.put(employee.getUuid(), employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Employee getEmployeeByUuid(UUID uuid) {
        return store.get(uuid);
    }

    @Override
    public Employee createEmployee(CreateEmployeeInput input) {
        EmployeeModel employee = new EmployeeModel();
        employee.setUuid(UUID.randomUUID());
        employee.setFirstName(input.getFirstName());
        employee.setLastName(input.getLastName());
        employee.setSalary(input.getSalary());
        employee.setAge(input.getAge());
        employee.setJobTitle(input.getJobTitle());
        employee.setEmail(input.getEmail());
        employee.setContractHireDate(Instant.now());
        store.put(employee.getUuid(), employee);
        return employee;
    }
}
