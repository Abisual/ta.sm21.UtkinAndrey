package com.nc.edu.ta.utkin.lab;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    WebDriver driver = new ChromeDriver();
    String result;

    //Xpath data
    String successfulReg = "//*[@id='content']/div/text()[1]";
    String invalidLogin = "//*[@id='registerForm']/table/tbody/tr[1]/td[3]/span";
    String invalidPassword = "//*[@id='registerForm']/table/tbody/tr[2]/td[3]/span";
    String invalidEmail = "//*[@id='registerForm']/table/tbody/tr[5]/td[3]/span";


    public StepDefinitions () {
        result = "";
    }


    public void registerSetup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static final Map<String, String> PAGES;
    private static final String DOMAIN = "https://inventory.edu-netcracker.com/";
    static {
        Map<String, String> aMap = new HashMap<String, String>();
        aMap.put("Login", DOMAIN+"login.jsp");
        aMap.put("Register", DOMAIN+"pages/registration.xhtml");
        PAGES = Collections.unmodifiableMap(aMap);
    }

    //tc_1_newUser.feature
    @Given("I am on {string} page")
    public void iamOnPage(String page) {
        driver.get(page);
    }

    @When("I enter {string} in {string} field")
    public void iEnterInField(String value, String field) {
        findElement(field).sendKeys(value);
    }

    @And("I select {string} in {string} dropdown field")
    public void iSelectInDropdownField(String field, String value) {
        new Select (findElement(field)).selectByValue(value);
    }

    @And("I press button {string}")
    public void iPressButton(String buttonName) {
        findByName(buttonName).click();
    }

    @Then("I should get a message {string}")
    public void iShouldGetAMessage(String message) {
        assertEquals(message, findByXpath(successfulReg));
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
        String element = String.valueOf(driver.findElement(By.xpath(xpath)));
        if (element != null) {
            return element;
        }
        return null;
    }
}
