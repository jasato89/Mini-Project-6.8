package com.ironhack.reworkedgebanksystem.controller.DTO;

import com.ironhack.reworkedgebanksystem.Utils.Money;

import java.time.LocalDateTime;

public class StudentCheckingDTO extends AccountInfoDTO{

    private String status;

    public StudentCheckingDTO() {
    }

    public StudentCheckingDTO(Money balance, AccountHolderInformationDTO accountHolder, AccountHolderInformationDTO secondaryAccountHolder, LocalDateTime creationDate, String status) {
        super(balance, accountHolder, secondaryAccountHolder, creationDate);
        this.status = status;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

