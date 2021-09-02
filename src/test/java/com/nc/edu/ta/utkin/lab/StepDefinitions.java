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
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    String result;
    private String email;
    static WebDriver driver = null;

    public StepDefinitions () {
        result = "";
        email = "";
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
    //Xpath data
    private static final Map<String, String> XPATH;
    static {
        Map<String, String> xMap = new HashMap<String, String>();
        xMap.put("UsernameDescription", "//*[@id='registerForm']/table/tbody/tr[1]/td[3]/label");
        xMap.put("PasswordDescription", "//*[@id='registerForm']/table/tbody/tr[2]/td[3]/label");
        xMap.put("RepeatPasswordDescription", "//*[@id='registerForm']/table/tbody/tr[3]/td[3]/label");
        xMap.put("EmailDescription", "//*[@id='registerForm']/table/tbody/tr[5]/td[3]/label");
        xMap.put("RoleDescription", "//*[@id='registerForm']/table/tbody/tr[6]/td[3]/label");
        //Error fields
        xMap.put("PasswordField", "//*[@id='registerForm']/table/tbody/tr[2]/td[3]/span");
        xMap.put("EmailField", "//*[@id='registerForm']/table/tbody/tr[5]/td[3]/span");
        xMap.put("LoginField", "//*[@id='registerForm']/table/tbody/tr[1]/td[3]/span");

        xMap.put("InfoAboutUsername", "Login must contain only alphanumeric characters and contain at least 6 characters");
        xMap.put("InfoAboutPassword", "The Password must have at least 8 characters, at least 1 digit, at least 1 lower case letter," +
                " at least 1 upper case letter, at least 1 non-alphanumeric character");
        xMap.put("InfoAboutRepeatPassword", "The Repeat password must be the same as the Password");
        xMap.put("InfoAboutEmail", "Enter here valid e-mail address");
        xMap.put("InfoAboutRole", "Pick corresponding role");

        xMap.put("PasswordLengthError", "Password length must me >= 8 and <= 50.");
        xMap.put("PasswordNumError", "At least one digit must be in password");
        xMap.put("PasswordLowError", "At least one lower letter must be in password");
        xMap.put("PasswordCapError", "At least one upper letter must be in password");
        xMap.put("PasswordMatchError", "Password must match confirm password.");
        xMap.put("EmailError", "Email address is incorrect.");
        xMap.put("LoginError", "Login must be alphanumeric string with length => 6 and <= 50.");
        XPATH = Collections.unmodifiableMap(xMap);
    }
    public String xPathData(String xPath) {
        return XPATH.get(xPath);
    }

    //Links data
    private static final Map<String, String> PAGES;
    private static final String DOMAIN = "https://inventory.edu-netcracker.com/";
    static {
        Map<String, String> aMap = new HashMap<String, String>();
        aMap.put("Login", DOMAIN+ "login.jsp");
        aMap.put("Register", DOMAIN+ "pages/registration.xhtml");
        aMap.put("SuccessfulRegistered", DOMAIN+"login.jsp?justRegistered=true");
        aMap.put("Startpage", DOMAIN+ "pages/startpage.xhtml");
        aMap.put("LoginError", DOMAIN + "login.jsp?error=true");
        PAGES = Collections.unmodifiableMap(aMap);
    }

    public String pageByName(String page) {
        return PAGES.get(page);
    }

    //tc_1_newUser.feature
    @Given("I am on {string} page")
    public void iamOnPage(String page) {
        registerSetup();
        driver().get(pageByName(page));
    }

    @When("I enter {string} in {string} field")
    public void iEnterInField(String value, String field) {
        findByName(field).sendKeys(value);
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
    public String findByXpathTitle (String xpath) {
        String element = (driver.findElement(By.xpath(xpath)).getAttribute("title"));
        if (element != null) {
            return element;
        }
        return null;
    }

    public String findByXpath (String xpath) {
        String element = driver.findElement(By.xpath(xpath)).getText();
        if (element != null) {
            return element;
        }
        return null;
    }

    //tc_2_usernameForm
    @When("I enter {string} in {string}")
    public void iEnterIn(String value, String field) {
        findByName(field).sendKeys(value);
    }

    //tc_3_checkDescription
    @When("I click on {string}")
    public void iClickOn(String descriptionLink) {
        result = findByXpathTitle(xPathData(descriptionLink));
    }

    @Then("I should get {string}")
    public void iShouldGet(String Data) {
        try {
            assertEquals(xPathData(Data), result);
        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            driver.quit();
        }
    }

    public String userGenerator () {
        double user = Math.random() * 1000;
        int userInt = (int) user;
        String generatedUser = String.valueOf(userInt);
        return generatedUser;
    }

    //tc_4_passwordForm
    @When("I enter Login in {string} field")
    public void iEnterLoginInField(String usernameField) {
        findByName(usernameField).sendKeys("TestUser" + userGenerator());
    }

    @Then("I should get error {string} near {string}")
    public void iShouldGetErrorNear(String error, String field) throws NoSuchElementException {
        result = findByXpath(xPathData(field));
        try {
            assertEquals(xPathData(error), result);
        } catch (NoSuchElementException e) {
            System.out.println("NOT FOUND");
        }
        finally {
            driver.quit();
        }
    }
    //tc_2_usernameForm
    @When("I enter Numerical Login in {string} field")
    public void iEnterNumericalLoginInField(String field) {
        findByName(field).sendKeys(userGenerator()+"1234");
    }
}
