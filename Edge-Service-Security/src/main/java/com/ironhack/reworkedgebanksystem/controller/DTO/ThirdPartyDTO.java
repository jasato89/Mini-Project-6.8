package com.ironhack.reworkedgebanksystem.controller.DTO;

import javax.validation.constraints.NotNull;

public class ThirdPartyDTO {

    @NotNull
    private String name;
    @NotNull
    private String hashedKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) {
        this.hashedKey = hashedKey;
    }
}
