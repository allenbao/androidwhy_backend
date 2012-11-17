package com.androidwhy.examples.showcase.functional;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import com.androidwhy.modules.test.selenium.Selenium2;
import com.androidwhy.modules.test.selenium.WebDriverFactory;

/**
 * 使用Selenium的功能测试基类.
 * 
 * 在BaseFunctionalTestCase的基础上，在整个测试期间启动一次Selenium.
 * 
 * @author Gordon
 */
public class BaseSeleniumTestCase extends BaseFunctionalTestCase {

	protected static Selenium2 s;

	@BeforeClass
	public static void createSeleniumOnce() throws Exception {
		if (s == null) {
			//根据配置创建Selenium driver.
			String driverName = propertiesLoader.getProperty("selenium.driver");

			WebDriver driver = WebDriverFactory.createDriver(driverName);

			s = new Selenium2(driver, baseUrl);
			s.setStopAtShutdown();
		}
	}
}
