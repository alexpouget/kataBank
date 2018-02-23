package fr.lacombe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class AccountServiceTest {

    private Account account;
    private AccountService accountService;

    @Before
    public void setUp() throws Exception {
        account = new Account();
        account = Mockito.spy(account);
        accountService = new AccountService(account);
    }

    @Test
    public void shouldDepositMoney() {
        Amount amount = Amount.parse(1000);
        LocalDate date = LocalDate.of(2012, 01, 10);
        Transaction credit = new Credit(amount, date);
        Mockito.doNothing().when(account).addTransaction(credit);

        accountService.deposit(amount, date);

        Mockito.verify(account).addTransaction(credit);
    }

    @Test
    public void shouldWithDrawalMoney() {
        Amount amount = Amount.parse(1000);
        LocalDate date = LocalDate.of(2012, 01, 10);
        Transaction debit = new Debit(amount, date);
        Mockito.doNothing().when(account).addTransaction(debit);

        accountService.withdrawal(amount, date);

        Mockito.verify(account).addTransaction(debit);
    }

    @Test
    public void printStatementCallAccountPrintTransactions() {
        accountService.printStatement();
        Mockito.verify(account).printTransactions();
    }

}