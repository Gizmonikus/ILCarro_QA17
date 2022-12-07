package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }



    public void submitLogin(){
        click(By.xpath("//button[@type='submit']"));
    }
    public void submitRegistration(){
        click(By.xpath("//button[2]"));
    }
    public void clickOkButton() {
        click(By.xpath("//button[text()='Ok']"));
    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));

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
//    public void login(String email, String password){
//        openLoginRegistrationForm();
//        fillLoginRegistrationForm(email, password);
//        submitLogin();
//        pause(10);
//    }

    public void FillAddForm(String name, String lastName, String phone, String email, String addres, String description){
        type(By.xpath("//input[@placeholder='Name']"), name);
        type(By.xpath("//input[@placeholder='Last Name']"), lastName);
        type(By.xpath("//input[@placeholder='Phone']"), phone);
        type(By.xpath("//input[@placeholder='email']"), email);
        type(By.xpath("//input[@placeholder='Address']"), addres);
        type(By.xpath("//input[@placeholder='description']"), description);
    }


}



