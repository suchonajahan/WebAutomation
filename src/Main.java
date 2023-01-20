import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static WebDriver driver;

    public static void main(String[] args) {
        //System.out.println("Hello world!");
       String currentDir = System.getProperty("user.dir");
        String path = currentDir + "/Resources/chromedriver";
        System.out.println(currentDir);

        System.setProperty("webdriver.chrome.driver", path);

        ChromeOptions options = new ChromeOptions();
        Map <String, Object> prefs = new HashMap <String, Object>();
        Map <String, Object> profile = new HashMap <String, Object>();
        Map <String, Integer> contentSettings = new HashMap <String, Integer>();

        //SET CHROME OPTIONS
        //0 - Default, 1 - Allow, 2 - Block

        contentSettings.put("notifications", 2);
        contentSettings.put("geolocation", 2);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.get("https://chaldal.com/");
        driver.manage().window().maximize();;

       // HashMap<Integer,String> map = new HashMap<Integer, String>();

         //map.put(1, "Mango");
         //map.put(2, "Orange");
         //map.put(3, "Watermelon");

         //System.out.println("Iterating Hashmap...");
         //for(Map.Entry m: map.entrySet()){
          //   System.out.println(m.getKey()+""+m.getValue());

         }
    }
