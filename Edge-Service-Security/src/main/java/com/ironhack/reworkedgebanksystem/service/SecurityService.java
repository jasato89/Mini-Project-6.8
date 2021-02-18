package com.ironhack.reworkedgebanksystem.service;

import com.ironhack.reworkedgebanksystem.Utils.Money;
import com.ironhack.reworkedgebanksystem.controller.DTO.*;
import com.ironhack.reworkedgebanksystem.client.BankingAppClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.*;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SecurityService {

    @Autowired
    private BankingAppClient bankingAppClient;

    private final CircuitBreakerFactory circuitBreakerFactory = new Resilience4JCircuitBreakerFactory();

    /** ACCOUNT **/

    public AccountInfoDTO getAccountById(Long id){
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");

        AccountInfoDTO accountInfoDTO = circuitBreaker.run(() -> bankingAppClient.getAccountById(id), throwable -> circuitBreakerCache());

        return accountInfoDTO;
    }

    private AccountInfoDTO circuitBreakerCache() {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "We didn't found what you're looking for. Try again after a few minutes.");
    }

    public Money getBalanceById(Long id){
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");

        return (Money) circuitBreaker.run(() -> bankingAppClient.getBalanceById(id), throwable -> circuitBreakerCache());
    };

    public List<AccountInfoDTO> getAllAccountsFromUser(Long userId){
                CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");

                return (List<AccountInfoDTO>) circuitBreaker.run(() -> bankingAppClient.getAllAccountsFromUser(userId), throwable -> circuitBreakerCache());
    };

    public void updateBalance(Long accountId,Money money){

    };

    public Money getBalance(Long accountId){
                CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");
        return (Money) circuitBreaker.run(() -> bankingAppClient.getBalance(accountId), throwable -> circuitBreakerCache());
    };

    /** ACCOUNT HOLDER **/

    public List<AccountHolderInformationDTO> getAllAccountHolders(){
                CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");
        return (List<AccountHolderInformationDTO>) circuitBreaker.run(() -> bankingAppClient.getAllAccountHolders(), throwable -> circuitBreakerCache());

    };

    public AccountHolderDTO createAccountHolder(AccountHolderDTO accountHolder){
                CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");
        return (AccountHolderDTO) circuitBreaker.run(() -> bankingAppClient.createAccountHolder(accountHolder), throwable -> circuitBreakerCache());

    };

    /** CHECKING **/

    public List<CheckingAccountDTO> getAllCheckingAccounts(){
                CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");
        return (List<CheckingAccountDTO>) circuitBreaker.run(() -> bankingAppClient.getAllCheckingAccounts(), throwable -> circuitBreakerCache());
    };

    public AccountInfoDTO createCheckingAccount(CheckingAccountDTO checkingAccount){
                CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");
        return (AccountInfoDTO) circuitBreaker.run(() -> bankingAppClient.createCheckingAccount(checkingAccount), throwable -> circuitBreakerCache());

    };

    public CheckingAccountDTO updateCheckingAccount(Long id, CheckingAccountDTO checkingAccount){
                CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");
        return (CheckingAccountDTO) circuitBreaker.run(() -> bankingAppClient.updateCheckingAccount(id, checkingAccount), throwable -> circuitBreakerCache());

    };

    /** CREDIT CARD **/

    public CreditCardDTO createCreditCardAccount(CreditCardDTO creditCard){
                CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");
        return (CreditCardDTO) circuitBreaker.run(() -> bankingAppClient.createCreditCardAccount(creditCard), throwable -> circuitBreakerCache());
    };


    /** SAVINGS **/

    public List<SavingsAccountDTO> getAllSavingsAccount(){
                CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");
        return (List<SavingsAccountDTO>) circuitBreaker.run(() -> bankingAppClient.getAllSavingsAccount(), throwable -> circuitBreakerCache());

    };

    public SavingsAccountDTO createSavingsAccount(SavingsAccountDTO savingsAccount){
                CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");
        return (SavingsAccountDTO) circuitBreaker.run(() -> bankingAppClient.createSavingsAccount(savingsAccount), throwable -> circuitBreakerCache());

    };

    public SavingsAccountDTO updateSavingsAccount(Long id,SavingsAccountDTO savingsAccount){
                CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");
        return (SavingsAccountDTO) circuitBreaker.run(() -> bankingAppClient.updateSavingsAccount(id, savingsAccount), throwable -> circuitBreakerCache());

    };

    /** STUDENT CHECKING **/

    public List<StudentCheckingDTO> getAllStudentCheckingAccounts(){
                CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");
        return (List<StudentCheckingDTO>) circuitBreaker.run(() -> bankingAppClient.getAllStudentCheckingAccounts(), throwable -> circuitBreakerCache());

    };

    public StudentCheckingDTO createStudentCheckingAccount(CheckingAccountDTO studentCheckingAccount){
                CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");
        return (StudentCheckingDTO) circuitBreaker.run(() -> bankingAppClient.createStudentCheckingAccount(studentCheckingAccount), throwable -> circuitBreakerCache());
    };

    public StudentCheckingDTO updateStudentCheckingAccount(Long id, StudentCheckingDTO studentCheckingAccount){
                CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");
        return (StudentCheckingDTO) circuitBreaker.run(() -> bankingAppClient.updateStudentCheckingAccount(id, studentCheckingAccount), throwable -> circuitBreakerCache());
    };

    /** THIRD PARTY **/

    public List<ThirdPartyDTO> getAllThirdPartyAccounts(){
                CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");
        return (List<ThirdPartyDTO>) circuitBreaker.run(() -> bankingAppClient.getAllThirdPartyAccounts(), throwable -> circuitBreakerCache());
    };

    public ThirdPartyDTO createThirdParty(ThirdPartyDTO thirdParty){
                CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");
        return (ThirdPartyDTO) circuitBreaker.run(() -> bankingAppClient.createThirdParty(thirdParty), throwable -> circuitBreakerCache());

    };

    public void sendMoney(String hashedKey, ThirdPartyTransactionDTO thirdPartyTransactionDTO){
        bankingAppClient.sendMoney(hashedKey, thirdPartyTransactionDTO);
    };

    public void receiveMoney(String hashedKey,ThirdPartyTransactionDTO thirdPartyTransactionDTO){
        bankingAppClient.receiveMoney(hashedKey, thirdPartyTransactionDTO);

    };

    /** TRANSACTION **/

    public Money sendMoney(TransactionDTO transactionDTO){
                CircuitBreaker circuitBreaker = circuitBreakerFactory.create("security-service");
        return (Money) circuitBreaker.run(() -> bankingAppClient.sendMoney(transactionDTO), throwable -> circuitBreakerCache());
    };
}
