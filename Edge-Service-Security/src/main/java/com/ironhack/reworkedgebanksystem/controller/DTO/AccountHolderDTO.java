package com.ironhack.reworkedgebanksystem.controller.DTO;

import org.apache.tomcat.jni.*;

import javax.persistence.Embedded;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.format.DateTimeFormatter;

public class AccountHolderDTO {
    @NotNull(message = "Username required")
    private String username;
    @NotNull(message = "Password required")
    private String password;
    private String dateOfBirth;
    @NotNull(message = "Name required")
    private String name;
    @Valid

    @NotNull(message = "Address required")
    private Address primaryAddress;
    @Valid
    private Address mailingAddress;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMuuuu");

    public AccountHolderDTO(@NotNull(message = "Username required") String username, @NotNull(message = "Password required") String password, String dateOfBirth, @NotNull(message = "Name required") String name, @Valid @NotNull(message = "Address required") Address primaryAddress, @Valid Address mailingAddress) {
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }


    public AccountHolderDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}
