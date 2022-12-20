import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @Test
    public void registrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User()
                .withName("Joe")
                .withLastName("Doe")
                .withEmail("joe" + i + "@mail.com")
                .withPassword("Bob12345@");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().pause(3000);
        app.getUser().submitRegistration();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isRegistered());
    }

    @Test
    public void registrationNegativeTestWithIncorrectPassword() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User()
                .withName("Joe")
                .withLastName("Doe")
                .withEmail("joe" + i + "@mail.com")
                .withPassword("ob12345");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().pause(3000);
        // app.getUser().submitRegistration();
        //app.getUser().pause(3000);
        //Assert.assertTrue(app.getUser().isRegistered());
    }

    @Test
    public void registrationNegativeTestWorning() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User data = new User()
                .withName("Vasia")
                .withLastName("Pupkin")
                .withEmail("vasia" + i + "@mail.com")
                .withPassword("Abcd");
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(data);
        app.getUser().submitRegistration();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[contains(text()," +
                "'Password must contain 1 uppercase letter')]")));


    }
}
