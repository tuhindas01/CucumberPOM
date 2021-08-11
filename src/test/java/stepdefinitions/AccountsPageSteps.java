package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		List<Map<String, String>> crdList = credTable.asMaps();
		String userName = crdList.get(0).get("username");
		String passWord = crdList.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.doLogin(userName, passWord);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountsPage.getAccountsPageTitle();
		System.out.println("Accounts Page Title is " +title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) {
		List<String> expectedAccountsSectionList = sectionTable.asList();
		System.out.println("Expected Account Section List : " +expectedAccountsSectionList);
		
	    List<String> actualAccountSectionList = accountsPage.getAccountsSectionList();
		System.out.println("Actual Account Section List : " +actualAccountSectionList);
		
		Assert.assertTrue(expectedAccountsSectionList.containsAll(actualAccountSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
	    Assert.assertTrue(accountsPage.getAccountSectionCount() == expectedSectionCount);
	}

}
