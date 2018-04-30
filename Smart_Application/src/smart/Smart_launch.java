package smart;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.basics.Settings;

public class Smart_launch {
	public static void main(String args[]) throws IOException, InterruptedException, FindFailed
	{
		Pattern image;
		WebDriver driver;
		
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/src/browserDriver/IEDriverServer.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability("requireWindowFocus", true);
		capabilities.setCapability("nativeEvents", true);    
		capabilities.setCapability("unexpectedAlertBehaviour", "accept");
		capabilities.setCapability("ignoreProtectedModeSettings", true);
		capabilities.setCapability("disable-popup-blocking", true);
		capabilities.setCapability("enablePersistentHover", true);
		driver = new InternetExplorerDriver(capabilities);
		
		
		/*System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/browserDriver/chromedriver.exe");
		driver=new ChromeDriver();*/
		
		
		driver.get("http://uat.kdms.in/installers/SMARTClient/SMART%20Client.application");
		Screen s=new Screen();
		driver.close();
		
		//  Click Run button
		image=new Pattern(System.getProperty("user.dir")+"/src/images/smart_application_run.png");
		s.click(image);
		System.out.println("Clicked on Run button");
		
		/*Settings.OcrTextRead=true;
		Settings.OcrTextSearch=true;
		System.out.println("Text is : "+s.text());*/

		//Enter the Username
		image=new Pattern(System.getProperty("user.dir")+"/src/images/smart_application_username.png");
		s.click(image);
		s.type(image,"admin");	
		System.out.println("Clicked on Username text field and Enter the details");

		//Enter the password
		image=new Pattern(System.getProperty("user.dir")+"/src/images/smart_application_pasword.png");
		s.click(image);
		s.type(image,"admin");	
		System.out.println("Clicked on Password text field and Enter the details");
		
		//Click on Login Button		
		image=new Pattern(System.getProperty("user.dir")+"/src/images/smart_application_login");
		s.click(image);
		System.out.println("Clicked on Login");

		//Click on the alert pop up winodw (In case of invalid User name and Password)
		image=new Pattern(System.getProperty("user.dir")+"/src/images/smart_application_ok");
		s.click(image);
		System.out.println("Handle the alert pop up window (If user credentials are wrong)");

		//Right Click on smart app from the menubar
		image=new Pattern(System.getProperty("user.dir")+"/src/images/smart_application_menu_bar");
		s.rightClick(image);
		System.out.println("Right click on the Smartapp From the menu bar");

		//click on Close button
		image=new Pattern(System.getProperty("user.dir")+"/src/images/smart_application_close");
		s.click(image);
		System.out.println("Clicked on Close window button");
	
	}

}
