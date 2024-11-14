package com.example.eercisecontrollerlayer2.BankManagementSystem;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BankManagementSystem {
    private String ID  ;
    private String Username ;
    private double Balance;
    private double Deposit;
    private double Withdraw;
}
