//email bobinsan20@yandex.ru
//password Bob12345@

package manager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {

    WebDriver wd;
HelperUser user;
HelperCar car;

    public void init(){
wd = new ChromeDriver();
//wd.manage().window().maximize();//что бы раскрыть окно браузера на весь экран
wd.navigate().to("https://ilcarro.web.app/");
user = new HelperUser(wd);
car = new HelperCar(wd);

    }

    public HelperCar getCar() {
        return car;
    }

    public HelperUser getUser() {

        return user;
    }
}
