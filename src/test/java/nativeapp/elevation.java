package nativeapp;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class elevation extends ApiDemo_capabilities {
	
	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void bt() throws MalformedURLException {
	 driver =capabilties();
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		
	}
	@Test(enabled  = true)
	public void switchappF_DROID() {
		//we are swithcapp to f_droid
		driver.activateApp("org.fdroid.fdroid");
	}
	
	@Test(alwaysRun = true ,dependsOnMethods= {"switchappF_DROID"})
	public void notifaction() {
		//notification
		driver.openNotifications();
		//clcik on battery
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();
		//clcik on battery off 
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();
		
	}
	@Test(alwaysRun = true ,dependsOnMethods= {"switchappF_DROID"})
	public void  scrollinto() {
		driver.findElement(MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Settings\"]/android.widget.FrameLayout/android.widget.ImageView")).click();	
		//scroll into the privacy
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Privacy\"))").click();
	}
	
	
	@Test(alwaysRun = true ,dependsOnMethods= {"switchappF_DROID"})
	public void  tap() {
		driver.findElement(MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Latest\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
		
		//another way useing text 
		AndroidElement freshman= driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Fennec F-Droid Browse the web\")"));
		//this is longpress method
			TouchAction ta = new TouchAction(driver);
			ta.longPress(longPressOptions().withElement(element(freshman)).withDuration(ofSeconds(3))).release().perform();
		 
		
		
	}
		
}
