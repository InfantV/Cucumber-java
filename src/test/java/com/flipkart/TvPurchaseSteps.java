package com.flipkart;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.mobile.objectRepository.TvPurchase;
import com.mobile.resources.Commonactions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class TvPurchaseSteps extends TvPurchase {
	TvPurchase tv=new TvPurchase();
    @When("user searches tv")
    public void search_mobile() {
        tv.getSearchBox().sendKeys("tv",Keys.ENTER);
    }
    @When("user searches tv {string}")
    public void search_mobile(String name) {
    	tv.getSearchBox().sendKeys(name,Keys.ENTER);
    }
    @When("user searches tv using one dim list")
    public void search_tv_using_one_dim_list(DataTable dataTable) {
    	List<String> asList=dataTable.asList();
    	tv.getSearchBox().sendKeys(asList.get(2),Keys.ENTER);
    }
    @When("user searches tv using one dim map")
    public void search_tv_using_one_dim_map(DataTable dataTable) {
    	Map<String,String> asMap=dataTable.asMap(String.class,String.class);
    	tv.getSearchBox().sendKeys(asMap.get("Tv1"),Keys.ENTER);
    }
    

}
