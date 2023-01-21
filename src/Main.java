import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
        String currentDir = System.getProperty("user.dir");
        String path = currentDir + "/Resources/chromedriver";
        System.out.println(currentDir);

        System.setProperty("webdriver.chrome.driver", path);

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Integer> contentSettings = new HashMap<String, Integer>();

        //SET CHROME OPTIONS
        //0 - Default, 1 - Allow, 2 - Block

        contentSettings.put("notifications", 2);
        contentSettings.put("geolocation", 2);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://chaldal.com/");
        driver.manage().window().maximize();


        //driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div/div[2]/h5")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div/div[3]/h5")).click();
//
//         HashMap<Integer,String> map = new HashMap<Integer, String>();
//
//        map.put(1, "Mango");
//        map.put(2, "Orange");
//        map.put(3, "Watermelon");
//
//        System.out.println("Iterating Hashmap...");
//        for(Map.Entry m: map.entrySet()){
//           System.out.println(m.getKey()+""+m.getValue());

//        ArrayList<String> list = new ArrayList<String>();
//
//        list.add("Mango");
//        list.add("Orange");
//        list.add("Guava");
//
//        Iterator itr = list.iterator();//getting the iterator
//        while (itr.hasNext()){
//            System.out.println(itr.next());


        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //Multiple tabs handling
        driver.switchTo().window(tabs2.get(0)); // to go to home page we are using get(0)


        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[1]/div[1]/form/div/div[1]/input")).sendKeys("egg");

        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[1]/div[1]/form/div/div[1]/input")).sendKeys(Keys.ENTER);


        driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/section/div/div/div/div/section/div[3]/div[2]/div[1]/div/section/p")).click();
        //Thread.sleep(1000);

        //WebDriverWait wait = new WebDriverWait(driver, 30);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("ddw")));
        //driver.findElement(By.xpath("jhj")).click();

        driver.navigate().back();
        String text = driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/section/div/div/div[1]/div/div/h2/span[2]")).getText();
        System.out.println(text);
    }
}