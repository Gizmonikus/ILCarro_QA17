import manager.NGListener;
import manager.ProviderData;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NGListener.class)
public class LoginTest extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logOut();
        }
    }
//Data Transfer Object(DTO)
    @Test(dataProvider = "loginModelDto", dataProviderClass = ProviderData.class)
    public void loginSuccessModel(User user){
        logger.info("User: " + user.toString());
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();

    }

    @Test
    public void loginSuccess() {
        User data = new User()
                .withEmail("bobinsan20@yandex.ru")
                //.withEmail("bobinsan20@yandex.ru")// w/o @
                .withPassword("Bob12345@");
        //.withPassword("Bob12345");// w/o @

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
    public void postCondition() {
        app.getUser().pause(3000);
        app.getUser().clickOkButton();
    }
}
