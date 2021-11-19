package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }

    @Given("user with username {string} with password {string} is successfully created")
    public void creatingAccount(String user, String pass) {
        validUsernameAndMatchingPasswordsAreEntered(user, pass);
        logOutAfterRegister();
    }

    @Given("user with username {string} and password {string} is tried to be created")
    public void invalidUsernameAndInvalidPasswordAreEntered(String user, String pass) {
        registerWith(user, pass, pass);
    }

    @Given("command new user is selected")
    public void newUserSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }

    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void validUsernameAndMatchingPasswordsAreEntered(String user, String pass) {
        registerWith(user, pass, pass);
    }

    @When("a valid username {string} and invalid password {string} and matching password confirmation are entered")
    public void validUsernameAndMatchingInvalidPasswordsAreEntered(String user, String pass) {
        registerWith(user, pass, pass);
    }

    @Then("user is not created and error \"password should have at least 8 characters and must contain number\" is reported")
    public void userNotCreatedAndInvalidPasswordError() {
        assertTrue(driver.getPageSource().contains("password should have at least 8 characters and must contain number"));
    }

    @Given("navigated to homepage")
    public void navigateToHomePage() {
        driver.get(baseUrl);
    }

    @When("a invalid username {string} and password {string} and matching password confirmation are entered")
    public void invalidUsernameAndMatchingPasswordsAreEntered(String user, String pass) {
        registerWith(user, pass, pass);
    }

    @Then("user is not created and error \"username should have at least 3 characters\" is reported")
    public void userNotCreatedAndTooShortUsernameError() {
        assertTrue(driver.getPageSource().contains("username should have at least 3 characters"));
    }

    @Then("a new user is created")
    public void newUserIsCreated() {
        pageHasContent("Welcome to Ohtu Application!");
    }

    @When("a valid username {string} and valid password {string} and not matching password confirmation are entered")
    public void validUsernameButNotMatchingPasswords(String user, String pass) {
        registerWith(user, pass, "lmao");
    }

    @Then("user is not created and error \"passwords does not match\" is reported")
    public void userNotCreatedWithNonMatchingPassword() {
        assertTrue(driver.getPageSource().contains("passwords does not match"));
    }
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    
    
    @When("username {string} and password {string} are given")
    public void usernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }   
    
    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }

    private void registerWith(String username, String password, String password2) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password2);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }

    private void logOutAfterRegister() {
        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        element = driver.findElement(By.linkText("logout"));
        element.click();
    }
}
