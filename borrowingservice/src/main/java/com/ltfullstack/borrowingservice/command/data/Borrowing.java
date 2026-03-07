package com.ltfullstack.borrowingservice.command.data;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "borrowing")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrowing {
    
    @Id
    private String id;

    private  String bookId;
    private String employeeId;
    private Date borrowingDate;
    private Date returnDate;
}
