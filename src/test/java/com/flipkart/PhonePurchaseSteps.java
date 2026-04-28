package com.flipkart;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mobile.objectRepository.PhonePurchase;
import com.mobile.resources.Commonactions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
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
    @And("user selects the product")
    public void selects_the_product() {
    	List<WebElement> products=Hooks1.driver.findElements(By.xpath("//div[@class=\"QSCKDh dLgFEE\"]"));
        for(WebElement p:products) {
       	 if(p.isDisplayed()) {
       	 p.click();
       	 break;
       	 } 
        }
    }
    @Then("user handling the window")
    public void user_handling_the_window()
    {
    	String parentwin=Hooks1.driver.getWindowHandle();
    	Set<String> allwin=Hooks1.driver.getWindowHandles();
    	for(String x:allwin) {
    		if(!parentwin.equals(x)) {
    			Hooks1.driver.switchTo().window(x);
    		}
    	}
    	
    	
    }
    @And("user clicks the review")
    public void user_clicks_the_review()
    {
    	WebDriverWait wait = new WebDriverWait(Hooks1.driver, Duration.ofSeconds(20));
    	WebElement rate = wait.until(ExpectedConditions.presenceOfElementLocated(
    		    By.xpath("html/body/div/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/div[4]/div/div/div/div/div/div/a/div/div/div/div/div")
    		));
    	System.out.println(rate.getTagName());
    	System.out.println(rate.getText());
    	rate.click();
    	
        	}


}
