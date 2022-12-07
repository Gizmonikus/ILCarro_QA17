import models.User;
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
        app.getUser().submitLogin();

    }

    @AfterMethod
    public void postCondition() {
        app.getUser().pause(5);
        app.getUser().clickOkButton();
    }

}