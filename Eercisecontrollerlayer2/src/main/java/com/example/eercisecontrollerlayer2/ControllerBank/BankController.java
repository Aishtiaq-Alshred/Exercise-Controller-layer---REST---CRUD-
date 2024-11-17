package com.example.eercisecontrollerlayer2.ControllerBank;
import com.example.eercisecontrollerlayer2.ApiResponse.ApiResponse;
import com.example.eercisecontrollerlayer2.BankManagementSystem.BankManagementSystem;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;



@RestController
@RequestMapping("/api/v1/Bank")

public class BankController {
    ArrayList<BankManagementSystem> bank = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<BankManagementSystem> getCustomers() {
        return bank;
    }

    @PostMapping("/add")
    public ApiResponse addnewCustomers(@RequestBody BankManagementSystem banks) {
        bank.add(banks);

        return new ApiResponse("added");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateCustomers(@PathVariable int index, @RequestBody BankManagementSystem model) {
        bank.set(index, model);
        return new ApiResponse("update");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteCustomers(@PathVariable int index) {

        bank.remove(index);
        return new ApiResponse("delete");
    }



    @PutMapping("/Withdraw/{index}/{amount}")
    public ApiResponse Withdraws(@PathVariable int index, @PathVariable double amount) {
        if(this.bank.get(index).getBalance()>=amount)
        this.bank.get(index).setBalance(this.bank.get(index).getBalance()-amount);
        return new ApiResponse("Withdrawal successful");
    }





    @PutMapping("/deposit/{index}/{amount}")
    public ApiResponse deposit(@PathVariable int index, @PathVariable double amount) {
        this.bank.get(index).setBalance(this.bank.get(index).getBalance()+amount);
        return new ApiResponse("Deposit successful");
    }
}
