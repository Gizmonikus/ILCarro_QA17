package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }



    public void submitLogin(){
        click(By.xpath("//button[@type='submit']"));
    }

    public void clickOkButton(){
        click(By.xpath("//button[@type='button']"));

    }

    public void submitRegistration(){
        click(By.xpath("//button[2]"));
    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public boolean isLoggedSuccess(){
        WebDriverWait wait = new WebDriverWait(wd, 10);
//        WebElement element = wd.findElement(
//                By.cssSelector(".dialog-container"));
//        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(
                By.cssSelector(".dialog-container"))));
//        System.out.println(element.getText());
        return wd.findElement(
                By.cssSelector(".dialog-container")).getText().contains("success");
    }
    public void logOut(){
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public void openLoginForm(){
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password){
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }
    public void fillLoginForm(User data){
        type(By.xpath("//input[@id='email']"), data.getEmail());
        type(By.xpath("//input[@id='password']"), data.getPassword());
    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submitLogin();
//        clickOkButton();
//        pause(5000);
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
        click(By.cssSelector("label[for='terms-of-use']"));
    }
}



