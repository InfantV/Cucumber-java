package com.flipkart;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Feature",
    glue = {"com.flipkart"},
    plugin = {"pretty", "html:target/report.html"},
    monochrome = true,
    tags = "@phone"
    )

public class TestRunner1 {

}
