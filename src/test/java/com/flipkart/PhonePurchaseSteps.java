package com.flipkart;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mobile.objectRepository.PhonePurchase;
import com.mobile.resources.Commonactions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PhonePurchaseSteps {
	Commonactions c=new Commonactions();
	PhonePurchase p=new PhonePurchase();
	static WebDriverWait wait;
    @Given("user launches browser")
    public void launch_browser() {
       Hooks1.driver.get("https://www.flipkart.com");
		wait=new WebDriverWait(Hooks1.driver, Duration.ofSeconds(10));
		WebElement close=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"b3wTlE\"]")));
        close.click();
    }
    @When("user searches mobile")
    public void search_mobile() {
        p.getSearchBox().sendKeys("mobile",Keys.ENTER);
    }

    @Then("user selects product")
    public void select_product() {
    	List<WebElement> products=Hooks1.driver.findElements(By.xpath("//div[@class=\"QSCKDh dLgFEE\"]"));
        for(WebElement p:products) {
       	 if(p.isDisplayed()) {
       	 p.click();
       	 break;
       	 } 
        }
    }
    @When("user searches mobile {string}")
    public void search_mobile(String name) {
    	p.getSearchBox().sendKeys(name,Keys.ENTER);
    }
    @When("user searches mobile using one dim list")
    public void search_mobile_using_one_dim_list(DataTable dataTable) {
    	List<String> asList=dataTable.asList();
    	p.getSearchBox().sendKeys(asList.get(1),Keys.ENTER);
    }
    @When("user searches mobile using one dim map")
    public void search_mobile_using_one_dim_map(DataTable dataTable) {
    	Map<String,String> asMap=dataTable.asMap(String.class,String.class);
    	p.getSearchBox().sendKeys(asMap.get("Phone1"),Keys.ENTER);
    }
    @When("user take screenshot")
    public void user_take_screenshot() throws IOException
    {
   	c.takeScreenshot();
    }

}
