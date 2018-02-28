package fr.lacombe;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.lacombe.amount.Amount;
import org.assertj.core.api.Assertions;

import java.time.LocalDate;

public class MyStepdefs {

    private Account account;
    private AccountService accountService;

    @Given("^i have a new account$")
    public void iHaveAAccountAtBalance() throws Throwable {
        account = new Account();
        accountService = new AccountService(account);
    }

    @When("^.* a deposit of (\\d+) at the date of (.*)$")
    public void aDepositOfAtTheDateOf(int amount,String date) throws Throwable {
        accountService.deposit(Amount.parse(amount), LocalDate.parse(date));
    }

    @And("^a withdrawal of (\\d+)  at the date of (.*)$")
    public void aWithdrawalOfAtTheDateOf(int amount, String date) throws Throwable {
        accountService.withdrawal(Amount.parse(amount), LocalDate.parse(date));
    }

    @Then("^i should have a statement like this \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void iShouldHaveAStatementLikeThis(String header, String statementOne, String statementtwo, String statementThree) throws Throwable {
        Assertions.assertThat(accountService.printStatement().toString()).isEqualTo(header+"\n"+statementOne+"\n"+statementtwo+"\n"+statementThree);
    }
}
