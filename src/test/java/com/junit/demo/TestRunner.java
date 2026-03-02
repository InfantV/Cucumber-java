package com.junit.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({MobilePurchase.class , TVPurchase.class})
public class TestRunner {

}
