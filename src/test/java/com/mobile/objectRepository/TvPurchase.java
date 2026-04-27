package com.mobile.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.Hooks1;
import com.mobile.resources.Commonactions;

public class TvPurchase extends Commonactions {

	public  TvPurchase()
	{
		PageFactory.initElements(Hooks1.driver, this);
	}
	public WebElement getSearchBox() {
		return searchBox;
	}


	@FindBy(name= "q")
	private WebElement searchBox;
}
