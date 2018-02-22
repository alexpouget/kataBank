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
        Transaction transaction = new Transaction(new Amount(1000), LocalDate.of(2012,01,10));
        Mockito.doNothing().when(account).addTransaction(transaction);

        accountService.deposit(new Amount(1000), LocalDate.of(2012,01,10));

        Mockito.verify(account).addTransaction(transaction);
    }
}