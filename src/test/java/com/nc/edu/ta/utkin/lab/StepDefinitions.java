package com.nc.edu.ta.utkin.lab;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    String result;
    static WebDriver driver = null;

    //Xpath data
    String successfulReg = "https://inventory.edu-netcracker.com/login.jsp?justRegistered=true";
    String invalidLogin = "//*[@id='registerForm']/table/tbody/tr[1]/td[3]/span";
    String invalidPassword = "//*[@id='registerForm']/table/tbody/tr[2]/td[3]/span";
    String invalidEmail = "//*[@id='registerForm']/table/tbody/tr[5]/td[3]/span";

    public StepDefinitions () {
        result = "";
    }

    @Before
    public void registerSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    static WebDriver driver () {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    private static final Map<String, String> PAGES;
    private static final String DOMAIN = "https://inventory.edu-netcracker.com/";
    static {
        Map<String, String> aMap = new HashMap<String, String>();
        aMap.put("Login", DOMAIN+"login.jsp");
        aMap.put("Register", DOMAIN+"pages/registration.xhtml");
        aMap.put("SuccessfulRegistered", DOMAIN+"login.jsp?justRegistered=true");
        PAGES = Collections.unmodifiableMap(aMap);
    }

    public String pageByName(String page) {
        return PAGES.get(page);
    }

    //tc_1_newUser.feature
    @Given("I am on {string} page")
    public void iamOnPage(String page) {
        driver().get(pageByName(page));
    }

    @When("I enter {string} in {string} field")
    public void iEnterInField(String value, String field) {
        findElement(field).sendKeys(value);
    }

    @And("I select {string} in {string} dropdown field")
    public void iSelectInDropdownField(String value, String field) {
        new Select(findElement(field)).selectByValue(value);
    }

    @And("I press button {string}")
    public void iPressButton(String buttonName) {
        findByName(buttonName).click();
    }

    @Then("I should get a page {string}")
    public void iShouldGetAPage(String expectedPage) {
        try {
            assertEquals(pageByName(expectedPage), driver().getCurrentUrl());
        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            driver.quit();
        }
    }
    public WebElement findElement (String field) {
            WebElement element = driver.findElement(By.id(field));
            if (element != null) {
                return element;
            }
        return null;
    }
    public WebElement findByName (String field) {
        WebElement element = driver.findElement(By.name(field));
        if (element != null) {
            return element;
        }
        return null;
    }
    public String findByXpath (String xpath) {
        String element = (driver.findElement(By.xpath(xpath)).getText());
        if (element != null) {
            return element;
        }
        return null;
    }
}
