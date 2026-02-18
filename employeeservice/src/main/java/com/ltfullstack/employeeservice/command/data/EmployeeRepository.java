package com.ltfullstack.employeeservice.command.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findAllByIsDisciplined(Boolean isDisciplined);
}
