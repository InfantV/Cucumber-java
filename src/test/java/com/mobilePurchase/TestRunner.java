package com.mobilePurchase;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src//test//resources//Feature",
					  glue = "com.mobilePurchase",
					plugin = "html:target/Repot-Cucumber.html",
				 monochrome = true,
				     dryRun = false,
				       tags = "@mobile"
		)
public class TestRunner {

}
