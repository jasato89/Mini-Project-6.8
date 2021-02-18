package com.ironhack.reworkedgebanksystem.controller.impl;

import com.ironhack.reworkedgebanksystem.Utils.Money;
import com.ironhack.reworkedgebanksystem.controller.DTO.*;
import com.ironhack.reworkedgebanksystem.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class EdgeBankSystemController {

    @Autowired
    private SecurityService securityService;

    /** ACCOUNT **/

    @GetMapping("/admin/account/id/{id}")
    public AccountInfoDTO getAccountById(@PathVariable("id") Long id){
        return securityService.getAccountById(id);
    };

    @GetMapping("/admin/account/{id}/balance")
    public Money getBalanceById(@PathVariable("id") Long id){
        return securityService.getBalanceById(id);
    };

    @GetMapping("/admin/account/{id}/accounts")
    public List<AccountInfoDTO> getAllAccountsFromUser(@PathVariable("id") Long userId){
        return securityService.getAllAccountsFromUser(userId);
    };

    @PostMapping("/admin/account/{id}/balance")
    public void updateBalance(@PathVariable("id") Long accountId,@RequestBody @Valid Money money){
        securityService.updateBalance(accountId, money);
    };

    @GetMapping("/my-accounts/{id}/balance")
    public Money getBalance(@PathVariable("id") Long accountId){
      return securityService.getBalance(accountId);
    };

    /** ACCOUNT HOLDER **/

    @GetMapping("/admin/account-holders")
    public List<AccountHolderInformationDTO> getAllAccountHolders(){
        return securityService.getAllAccountHolders();
    };

    @PostMapping("/admin/create-account-holder")
    public AccountHolderDTO createAccountHolder(@RequestBody AccountHolderDTO accountHolder){
        return securityService.createAccountHolder(accountHolder);
    };

    /** CHECKING **/

    @GetMapping("/admin/checking-accounts")
    public List<CheckingAccountDTO> getAllCheckingAccounts(){
        return securityService.getAllCheckingAccounts();
    };

    @PostMapping("/admin/checking-account/new/")
    public AccountInfoDTO createCheckingAccount(@RequestBody @Valid CheckingAccountDTO checkingAccount){
        return securityService.createCheckingAccount(checkingAccount);
    };

    @PostMapping("/admin/checking-account/{id}")
    public CheckingAccountDTO updateCheckingAccount(@PathVariable Long id, @RequestBody CheckingAccountDTO checkingAccount){
        return securityService.updateCheckingAccount(id, checkingAccount);
    };

    /** CREDIT CARD **/

    @PostMapping("/credit-card/new")
    public CreditCardDTO createCreditCardAccount(@RequestBody @Valid CreditCardDTO creditCard){
        return securityService.createCreditCardAccount(creditCard);
    };


    /** SAVINGS **/

    @GetMapping("/admin/savings-accounts")
    public List<SavingsAccountDTO> getAllSavingsAccount(){
        return securityService.getAllSavingsAccount();
    };

    @PostMapping("/admin/savings-account/new")
    public SavingsAccountDTO createSavingsAccount(@RequestBody @Valid SavingsAccountDTO savingsAccount){
        return securityService.createSavingsAccount(savingsAccount);
    };

    @PostMapping("/admin/savings-account/{id}")
    public SavingsAccountDTO updateSavingsAccount(@PathVariable Long id, @RequestBody SavingsAccountDTO savingsAccount){
        return securityService.updateSavingsAccount(id, savingsAccount);
    };

    /** STUDENT CHECKING **/

    @GetMapping("/admin/student-checking-accounts")
    public List<StudentCheckingDTO> getAllStudentCheckingAccounts(){
        return securityService.getAllStudentCheckingAccounts();
    };

    @PostMapping("/admin/student-checking-account/new")
    public StudentCheckingDTO createStudentCheckingAccount(@RequestBody @Valid CheckingAccountDTO studentCheckingAccount){
        return securityService.createStudentCheckingAccount(studentCheckingAccount);
    };

    @PatchMapping("/admin/student-checking-account/{id}")
    public StudentCheckingDTO updateStudentCheckingAccount(@PathVariable("id") Long id, @RequestBody @Valid StudentCheckingDTO studentCheckingAccount){
        return securityService.updateStudentCheckingAccount(id, studentCheckingAccount);
    };

    /** THIRD PARTY **/

    @GetMapping("/admin/third-party-accounts")
    public List<ThirdPartyDTO> getAllThirdPartyAccounts(){
        return securityService.getAllThirdPartyAccounts();
    };

    @PostMapping("/admin/third-party-account/new")
    public ThirdPartyDTO createThirdParty(@RequestBody @Valid ThirdPartyDTO thirdParty){
        return securityService.createThirdParty(thirdParty);
    };

    @PostMapping("/third-party/send-money")
    public void sendMoney(@RequestHeader @NotNull String hashedKey, @RequestBody @Valid ThirdPartyTransactionDTO thirdPartyTransactionDTO){
         securityService.sendMoney(hashedKey, thirdPartyTransactionDTO);
    };

    @PostMapping("/third-party/receive-money")
    public void receiveMoney(@RequestHeader @NotNull String hashedKey,@RequestBody @Valid ThirdPartyTransactionDTO thirdPartyTransactionDTO){
         securityService.receiveMoney(hashedKey, thirdPartyTransactionDTO);
    };

    /** TRANSACTION **/

    @PostMapping("/transfer")
    public Money sendMoney(@RequestBody @Valid TransactionDTO transactionDTO){
        return securityService.sendMoney(transactionDTO);
    };
}
