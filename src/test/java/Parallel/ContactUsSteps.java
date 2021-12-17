package Parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.pages.ContactUsPage;
import com.qa.factory.DriverFactory;
import com.qa.utill.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ContactUsSteps {
	
	private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());

	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
	}
	
	@When("user fills the form from the given sheetname ContactUs and rownumber {int}")
	public void user_fills_the_form_from_the_given_sheetname_contact_us_and_rownumber(Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = reader.getData("C:\\Users\\dastu\\eclipse-workspace\\CucmberPOM\\src\\test\\resources\\InputSheets\\Automation.xlsx", "ContactUs");
		
		String heading = testData.get(rowNumber).get("subjectheading");
		String emailId = testData.get(rowNumber).get("email");
		String orderId = testData.get(rowNumber).get("orderref");
		String msg = testData.get(rowNumber).get("message");
		
		contactUsPage.fillContactUsForm(heading, emailId, orderId, msg);
	}
	
	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
		contactUsPage.clickSend();
	}
	
	@Then("it shows successfull message {string}")
	public void it_shows_successfull_message(String expectedSuccessMessage) {
		String successMessage = contactUsPage.getSuccessMessg();
		Assert.assertEquals(successMessage, expectedSuccessMessage);
		
	   
	}


}
