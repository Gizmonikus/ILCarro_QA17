import models.User;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @Test
    public void registrationPositiveTest(){
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User()
                .withName("Joe")
                .withLastName("Doe")
                .withEmail("Joe"+ i + "@mail.com")
                .withPassword("Bob12345@");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        //app.getUser().submitRegistrationForm();
    }

}
