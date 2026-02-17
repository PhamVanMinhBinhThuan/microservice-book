package com.ltfullstack.employeeservice.command.data;

import java.util.Optional;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ltfullstack.employeeservice.command.event.EmployeeCreatedEvent;
import com.ltfullstack.employeeservice.command.event.EmployeeUpdatedEvent;

import jakarta.ws.rs.NotFoundException;

@Component
public class EmployeeEventHandler {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @EventHandler
    private void on(EmployeeCreatedEvent event) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(event, employee);
        employeeRepository.save(employee);
    }

    @EventHandler
    private void on(EmployeeUpdatedEvent event) {
        Optional<Employee> oldEmployee = employeeRepository.findById(event.getId());
        
        Employee employee = oldEmployee.orElseThrow(() -> new NotFoundException("Employee not found"));
        employee.setFirstName(event.getFirstName());
        employee.setLastName(event.getLastName());
        employee.setKin(event.getKin());
        employee.setIsDisciplined(event.getIsDisciplined());
        
        employeeRepository.save(employee);
    }
}
