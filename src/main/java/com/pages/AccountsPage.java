package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	private By accountSections = By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public int getAccountSectionCount() {
		return driver.findElements(accountSections).size() - 1;
	}
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
	
	public List<String> getAccountsSectionList() {
		List<String> accountList = new ArrayList<>();
		List<WebElement> accountSectionList = driver.findElements(accountSections);
		
		for(WebElement e : accountSectionList) {
			String text = e.getText();
			System.out.println(text);
			accountList.add(text);
		}
		
		return accountList;
	}

}
