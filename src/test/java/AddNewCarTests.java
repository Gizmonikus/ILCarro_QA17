import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged() == false) {
            app.getUser()
                    .login(new User()
                            .withEmail("bobinsan20@yandex.ru")
                            .withPassword("Bob12345@")
                    );
            app.getUser().pause(3000);
            app.getUser().clickOkButton();
        }
    }

    @Test
    public void addNewCarPositive() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);//генератор случайных чисел

        Car car = Car.builder()
                .address("Tel Aviv")
                .make("KIA")
                .model("Sportage")
                .year("2020")
                .fuel("Petrol")
                .seats("4")
                .carClass("5")
                .carRegNumber("14434"+i)
                .price("150")
                .build();

        app.getUser().pause(5000);
        app.getCar().openCarForm();
//        Assert.assertTrue(app.getCar().isCarFormPresent());
        app.getUser().pause(5000);
        app.getCar().fillCarForm(car);
        app.getUser().pause(5000);
        app.getCar().submitForm();
        logger.info("Car added with: \n " + car.toString());
    }

//    @AfterMethod
}



