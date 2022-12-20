import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
//    @BeforeMethod
//    public void precondition() {
//        if (app.getUser().isLogged()) {
//            app.getUser().logOut();
//        }

    @Test
    public void registrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User()
                .withName("Joe")
                .withLastName("Doe")
                .withEmail("joe" + i + "@mail.com")
                .withPassword("Bob12345@");

        logger.info("registrationPositiveTest with email: " + user.getEmail()
                + "password: " + user.getPassword());

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().pause(3000);
        app.getUser().submitRegistration();
        app.getUser().pause(3000);
        //Assert.assertTrue(app.getUser().isRegistered());
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
                .withName("David")
                .withLastName("Davidson")
                .withEmail("david" + i + "@mail.com")
                .withPassword("Abcd");
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(data);
        app.getUser().submitRegistration();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[contains(text()," +
                "'Password must contain 1 uppercase letter')]")));
    }

}
