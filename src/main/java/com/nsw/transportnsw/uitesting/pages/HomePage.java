package com.nsw.transportnsw.uitesting.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "search-input-From")
	WebElement startLocation;

	@FindBy(name = "search-input-To")
	WebElement destinationLocation;

	@FindBy(id = "search-button")
	WebElement goButton;

	@FindBy(css = "div.list-group-item-title.ng-binding")
	WebElement dropdownlist;

	@FindBy(css = "div[role='listitem']")
	List<WebElement> resultList;

	private void enterSource(String location) {
		startLocation.sendKeys(location);
		selectValueFromDropDown(location);
	}

	private void enterDestination(String location) {
		destinationLocation.sendKeys(location);
		selectValueFromDropDown(location);
			}

	private void clickGoButton() {
		goButton.click();
			}

	private void selectValueFromDropDown(String value) {

		wait.until(ExpectedConditions.visibilityOf(dropdownlist));
		By dropdownValue = By.xpath("//div[@class='list-group-item-title ng-binding' and text()='" + value + "']");
		driver.findElement(dropdownValue).click();

	}

	public int getNumberOfResultsDisplayed() {
		wait.until(ExpectedConditions.visibilityOfAllElements(this.resultList));
		return resultList.size();
	}

	public void planTrip(String startLocation, String destLocation) {
		enterSource(startLocation);
		this.enterDestination(destLocation);
		this.clickGoButton();
	}
}
