package fr.lacombe;

import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class AccountServiceTest {

    @Test
    public void shouldDepositMoney() {
        Account account = new Account();
        account = Mockito.spy(account);
        AccountService accountService = new AccountService(account);
        Amount amount = new Amount(1000);
        LocalDate of = LocalDate.of(2012, 01, 10);
        Transaction transaction = new Transaction(amount, of);
        Mockito.doNothing().when(account).addTransaction(transaction);

        accountService.deposit(amount, of);

        Mockito.verify(account).addTransaction(transaction);
    }
}