package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {

    WebDriver wd;

    public void init(){
wd = new ChromeDriver();
wd.manage().window().maximize();//что бы раскрыть окно браузера на весь экран
wd.navigate().to("https://ilcarro-1578153671498.web.app/search");

    }

}
