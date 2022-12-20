import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logOut();
        }
    }

    @Test
    public void loginSuccess() {
        User data = new User()
                .withEmail("bobinsan20@yandex.ru")
                .withPassword("Bob12345@");

        app.getUser().openLoginForm();
        //app.getUser().fillLoginForm("bobinsan20@yandex.ru", "Bob12345@");
        app.getUser().fillLoginForm(data);
        app.getUser().pause(5000);
        app.getUser().submitLogin();
        //Assert.assertTrue(app.getUser().isLoggedSuccess());
    }

    @Test
    public void loginNegativeMail() {
        User data = new User()
                .withEmail("abcd@mail.bob")
                .withPassword("@Abcd1234");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("abcd@mail.bob", "@Abcd1234");
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h1[.='Login failed']")));

    }

    @AfterMethod
    public void postCondition(){
        app.getUser().pause(3000);
        app.getUser().clickOkButton();
    }
}
