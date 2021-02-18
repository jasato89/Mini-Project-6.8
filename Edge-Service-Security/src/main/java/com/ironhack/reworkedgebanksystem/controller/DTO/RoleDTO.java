package com.ironhack.reworkedgebanksystem.controller.DTO;

import javax.validation.constraints.NotNull;
import com.ironhack.reworkedgebanksystem.controller.DTO.*;

public class RoleDTO {

    @NotNull(message = "Role must be defined")
    private String role;
    @NotNull(message = "User must be defined")
    private UserDTO userDTO;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }


}
