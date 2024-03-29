package utilities;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating a private constructor, so we are closing
    access to the object of this class from outside the class
     */
    private Driver(){}

    /*
    We make WebDriver private, because we want to close access from outside the class.
    We make it static because we will use it in a static method.
     */
    private static WebDriver driver; // value is null by default

    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */
    public static WebDriver getDriver(){

        if (driver == null){

            /*
            We read our browserType from configuration.properties.
            This way, we can control which browser is opened from outside our code, from configuration.properties.
             */
            String browserType = ConfigReader.getProperty("browser");


            /*
                Depending on the browserType that will be return from configuration.properties file
                switch statement will determine the case, and open the matching browser
            */
            switch (browserType){

                case "chrome":
                  // System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
                   driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));


//                    ChromeOptions chromeOptions = new ChromeOptions();
//                    chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
//                    chromeOptions.setPageLoadTimeout(Duration.ofSeconds(14));

                    //1-asagideki 3 satirdaki kodlar testleri Headless (Jenkins gibi) kosmak istedigimiz yerlerde aktive edilebilir
//                    ChromeOptions options = new ChromeOptions();
//                    options.addArguments("--headless"); // Başsız modu etkinleştir
//                    options.addArguments("--disable-gpu"); // GPU kullanımını devre dışı bırak

                    //2- yukardaki options objesini ChromeDriver() icine parametre olarak atiyorum
//                    driver = new ChromeDriver(options);
/* Notification popup kapatmak icin asagidaki kodlar kullanilir
 Map<String, Object> prefs = new HashMap<String, Object>();

    //asagiya izin vermek icin 1 reddetmek icin 2 yazilir
    prefs.put("profile.default_content_setting_values.notifications", 2);

    ChromeOptions options = new ChromeOptions();

    options.setExperimentalOption("prefs", prefs);

                    driver = new ChromeDriver(options);
 */


                    break;

                case "safari" :
                    driver=new SafariDriver();

                    break;

                case "edge" :
                    driver=new EdgeDriver();

                    break;
                case "firefox":
                    driver = new FirefoxDriver();

                    break;

                default:
                    System.out.println("Unknown browser type: "+browserType);
                    driver=null;

            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }

        return driver;

    }

    /*
    This method will make sure our driver value is always null after using quit() method
     */
    public static void closeDriver(){
        if (driver != null){
            driver.quit(); // this line will terminate the existing session. Value will not even be null
            driver = null;
        }
    }
}