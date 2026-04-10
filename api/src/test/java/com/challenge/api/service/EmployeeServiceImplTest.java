package com.challenge.api.service;

import static org.junit.jupiter.api.Assertions.*;

import com.challenge.api.model.CreateEmployeeInput;
import com.challenge.api.model.Employee;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeServiceImplTest 
{

    private EmployeeServiceImpl service;

    @BeforeEach
    void setUp() 
    {
        service = new EmployeeServiceImpl();
    }

    @Test
    void getAllEmployees_returnsSeededData() 
    {
        List<Employee> employees = service.getAllEmployees();
        assertEquals(3, employees.size());
    }

    @Test
    void getEmployeeByUuid_existingEmployee_returnsEmployee()
    {
        Employee seeded = service.getAllEmployees().get(0);
        Employee found = service.getEmployeeByUuid(seeded.getUuid());

        assertNotNull(found);
        assertEquals(seeded.getUuid(), found.getUuid());
        assertEquals(seeded.getFirstName(), found.getFirstName());
    }

    @Test
    void getEmployeeByUuid_nonExistentUuid_returnsNull() 
    {
        Employee result = service.getEmployeeByUuid(UUID.randomUUID());
        assertNull(result);
    }

    @Test
    void createEmployee_validInput_returnsCreatedEmployee() 
    {
        CreateEmployeeInput input = new CreateEmployeeInput();
        input.setFirstName("Sudhir");
        input.setLastName("Chaudhary");
        input.setSalary(85000);
        input.setAge(25);
        input.setJobTitle("Junior Developer");
        input.setEmail("sudhir.chaudhary@bmw.com");

        Employee created = service.createEmployee(input);

        assertNotNull(created.getUuid());
        assertEquals("Sudhir", created.getFirstName());
        assertEquals("Chaudhary", created.getLastName());
        assertEquals("Sudhir Chaudhary", created.getFullName());
        assertEquals(85000, created.getSalary());
        assertEquals("Junior Developer", created.getJobTitle());
        assertEquals("sudhir.chaudhary@bmw.com", created.getEmail());
        assertNotNull(created.getContractHireDate());
    }

    @Test
    void createEmployee_employeeIsPersisted() 
    {
        CreateEmployeeInput input = new CreateEmployeeInput();
        input.setFirstName("Sameer");
        input.setLastName("More");
        input.setSalary(63000);
        input.setAge(22);
        input.setJobTitle("Intern");
        input.setEmail("sameer.more@bmw.com");

        Employee created = service.createEmployee(input);
        assertEquals(4, service.getAllEmployees().size());
        Employee found = service.getEmployeeByUuid(created.getUuid());
        assertNotNull(found);
        assertEquals("Sameer", found.getFirstName());
    }
}
