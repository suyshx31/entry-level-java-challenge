package com.challenge.api.model;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class EmployeeModel implements Employee {

    private UUID uuid;
    private String firstName;
    private String lastName;
    private String fullName;
    private Integer salary;
    private Integer age;
    private String jobTitle;
    private String email;
    private Instant contractHireDate;
    private Instant contractTerminationDate;

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String name) {
        this.firstName = name;
        refreshFullName();
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String name) {
        this.lastName = name;
        refreshFullName();
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public void setFullName(String name) {
        this.fullName = name;
    }

    @Override
    public Integer getSalary() {
        return salary;
    }

    @Override
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Instant getContractHireDate() {
        return contractHireDate;
    }

    @Override
    public void setContractHireDate(Instant date) {
        this.contractHireDate = date;
    }

    @Override
    public Instant getContractTerminationDate() {
        return contractTerminationDate;
    }

    @Override
    public void setContractTerminationDate(Instant date) {
        this.contractTerminationDate = date;
    }

    private void refreshFullName() {
        if (firstName == null || lastName == null) {
            return;
        }
        this.fullName = firstName.trim() + " " + lastName.trim();
    }

    @Override
    public String toString() {
        return "EmployeeModel{"
                + "uuid=" + uuid
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", fullName='" + fullName + '\''
                + ", salary=" + salary
                + ", age=" + age
                + ", jobTitle='" + jobTitle + '\''
                + ", email='" + email + '\''
                + ", contractHireDate=" + contractHireDate
                + ", contractTerminationDate=" + contractTerminationDate
                + '}';
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmployeeModel that)) {
            return false;
        }
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
