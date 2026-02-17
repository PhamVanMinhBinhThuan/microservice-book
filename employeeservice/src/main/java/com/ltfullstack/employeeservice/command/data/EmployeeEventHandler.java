package com.ltfullstack.employeeservice.command.data;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ltfullstack.employeeservice.command.event.EmployeeCreatedEvent;

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
}
