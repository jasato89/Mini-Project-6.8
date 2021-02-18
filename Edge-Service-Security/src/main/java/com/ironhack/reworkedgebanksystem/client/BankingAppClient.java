package com.ironhack.reworkedgebanksystem.client;

import com.ironhack.reworkedgebanksystem.Utils.Money;
import com.ironhack.reworkedgebanksystem.controller.DTO.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@FeignClient(name = "bankingApp-service")
public interface BankingAppClient {

    /** ACCOUNT **/

    @GetMapping("/admin/account/id/{id}")
    public AccountInfoDTO getAccountById(@PathVariable("id") Long id);

    @GetMapping("/admin/account/{id}/balance")
    public Money getBalanceById(@PathVariable("id") Long id);

    @GetMapping("/admin/account/{id}/accounts")
    public List<AccountInfoDTO> getAllAccountsFromUser(@PathVariable("id") Long userId);

    @PostMapping("/admin/account/{id}/balance")
    public void updateBalance(@PathVariable("id") Long accountId,@RequestBody @Valid Money money);

    @GetMapping("/my-accounts/{id}/balance")
    public Money getBalance(@PathVariable("id") Long accountId);

    /** ACCOUNT HOLDER **/

    @GetMapping("/admin/account-holders")
    public List<AccountHolderInformationDTO> getAllAccountHolders();

    @PostMapping("/admin/create-account-holder")
    public AccountHolderDTO createAccountHolder(@RequestBody AccountHolderDTO accountHolder);

    /** CHECKING **/

    @GetMapping("/admin/checking-accounts")
    public List<CheckingAccountDTO> getAllCheckingAccounts();

    @PostMapping("/admin/checking-account/new/")
    public AccountInfoDTO createCheckingAccount(@RequestBody @Valid CheckingAccountDTO checkingAccount);

    @PostMapping("/admin/checking-account/{id}")
    public CheckingAccountDTO updateCheckingAccount(@PathVariable Long id, @RequestBody CheckingAccountDTO checkingAccount);

    /** CREDIT CARD **/

    @GetMapping("/credit-cards")
    public List<CreditCardDTO> getAllCreditCards();

    @PostMapping("/credit-card/new")
    public CreditCardDTO createCreditCardAccount(@RequestBody @Valid CreditCardDTO creditCard);

    @PostMapping("/credit-card/{id}")
    public CreditCardDTO updateCreditCardAccount(@PathVariable("id") Long id, @RequestBody CreditCardDTO creditCard);

    /** SAVINGS **/

    @GetMapping("/admin/savings-accounts")
    public List<SavingsAccountDTO> getAllSavingsAccount();

    @PostMapping("/admin/savings-account/new")
    public SavingsAccountDTO createSavingsAccount(@RequestBody @Valid SavingsAccountDTO savingsAccount);

    @PostMapping("/admin/savings-account/{id}")
    public SavingsAccountDTO updateSavingsAccount(@PathVariable Long id, @RequestBody SavingsAccountDTO savingsAccount);

    /** STUDENT CHECKING **/

    @GetMapping("/admin/student-checking-accounts")
    public List<StudentCheckingDTO> getAllStudentCheckingAccounts();

    @PostMapping("/admin/student-checking-account/new")
    public StudentCheckingDTO createStudentCheckingAccount(@RequestBody @Valid CheckingAccountDTO studentCheckingAccount);

    @PatchMapping("/admin/student-checking-account/{id}")
    public StudentCheckingDTO updateStudentCheckingAccount(@PathVariable("id") Long id, @RequestBody @Valid StudentCheckingDTO studentCheckingAccount);

    /** THIRD PARTY **/

    @GetMapping("/admin/third-party-accounts")
    public List<ThirdPartyDTO> getAllThirdPartyAccounts();

    @PostMapping("/admin/third-party-account/new")
    public ThirdPartyDTO createThirdParty(@RequestBody @Valid ThirdPartyDTO thirdParty);

    @PostMapping("/third-party/send-money")
    public void sendMoney(@RequestHeader @NotNull String hashedKey, @RequestBody @Valid ThirdPartyTransactionDTO thirdPartyTransactionDTO);

    @PostMapping("/third-party/receive-money")
    public void receiveMoney(@RequestHeader @NotNull String hashedKey,@RequestBody @Valid ThirdPartyTransactionDTO thirdPartyTransactionDTO);

    /** TRANSACTION **/

    @PostMapping("/transfer")
    public Money sendMoney(@RequestBody @Valid TransactionDTO transactionDTO);

}
