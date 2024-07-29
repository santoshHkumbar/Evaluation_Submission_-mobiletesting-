package nativeapp;

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
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;

//static import  for longpress
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//static import  for element
import static io.appium.java_client.touch.offset.ElementOption.element;
//sataic import for time
import  static java.time.Duration.ofSeconds;

public class Api_demos extends ApiDemo_capabilities {

	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void bt() throws MalformedURLException {
	 driver =capabilties();
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		
	}
	@Test(enabled = false)
	public void Preference_dependencies() {
	  driver.findElement(MobileBy.AccessibilityId("Preference")).click();	
	  driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
	  driver.findElement(MobileBy.id("android:id/checkbox")).click();
	 driver.findElement(MobileBy.id("android:id/checkbox")).click();
	  //another way useing text 
	  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
	  
	  driver.findElement(MobileBy.id("android:id/edit")).sendKeys("daya");
	  driver.findElement(MobileBy.id("android:id/button2")).click();
	  
	  driver.hideKeyboard();
	  //if u want to navigatuon back to thr prev screen
	  driver.pressKey(new KeyEvent(AndroidKey.BACK));
	  driver.pressKey(new KeyEvent(AndroidKey.BACK));
	  driver.pressKey(new KeyEvent(AndroidKey.BACK));
	  }

//	@Test(alwaysRun = false)
//	public void notifaction() {
//		driver.openNotifications();
//		driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();
//	}
	@Test (enabled  = false)
	public void media(){
		
		 driver.findElement(MobileBy.AccessibilityId("Media")).click();	
		 driver.findElement(MobileBy.AccessibilityId("VideoView")).click();	
		 driver.findElement(MobileBy.id("io.appium.android.apis:id/surface_view")).click();
		 
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 driver.pressKey(new KeyEvent(AndroidKey.BACK)); 		
	
	}	
	@Test (enabled  = false)
	public void scroll_views(){
		driver.findElement(MobileBy.AccessibilityId("Views")).click();	
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Expandable Lists\"))").click();
		driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();	
		AndroidElement freshman = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Fish Names\"))");
		
		//this is longpress method
		TouchAction ta = new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(freshman)).withDuration(ofSeconds(3))).release().perform();
	
	}
	
	
	
	
	
	
	
	@Test(enabled  = false)
	public void typeswipe() {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Date Widgets\"))").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"2. Inline\"))").click();
		
		AndroidElement e1=driver.findElement(MobileBy.AccessibilityId("12"));
		AndroidElement e2=driver.findElement(MobileBy.AccessibilityId("7"));
		
		TouchAction ta = new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(e1)).withDuration(ofSeconds(3))).moveTo(element(e2)).release().perform();
		
		AndroidElement e3=driver.findElement(MobileBy.AccessibilityId("15"));
		AndroidElement e4=driver.findElement(MobileBy.AccessibilityId("45"));
		ta.longPress(longPressOptions().withElement(element(e3)).withDuration(ofSeconds(3))).moveTo(element(e4)).release().perform();
		
		driver.findElement(MobileBy.id("android:id/am_label")).click();
	
	}

	@Test(enabled  = false)
	public void typeswipeuseingdroganddrop() {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Drag and Drop\"))").click();
		
		
		AndroidElement e5=driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_1"));
		AndroidElement e6=driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_2"));
		TouchAction ta = new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(e5)).withDuration(ofSeconds(3))).moveTo(element(e6)).release().perform();
	}
	
	
	
	@Test(enabled  = true)
	public void switchapp() {
		driver.findElement(MobileBy.AccessibilityId("OS")).click();
		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
		driver.findElement(MobileBy.AccessibilityId("Enable SMS broadcast receiver")).click();
		
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(650)555-1212");
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("HELLO MASAI SCHOOL");
		driver.findElement(MobileBy.AccessibilityId("Send")).click();
		
		 //driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		 
		 driver.activateApp("com.google.android.apps.messaging");
		 String  exp=  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"HELLO MASAI SCHOOL\"))").getText();
		  System.out.print(exp);
		  
		  driver.activateApp("io.appium.android.apis");
		
		
	}
	
}
