package com.fawry.intern.atm.commen;

import com.fawry.intern.atm.repository.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountModel {

    private long userId;
    private double balance;
    private String name;
    private Status status;
}
