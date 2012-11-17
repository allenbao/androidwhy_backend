package com.androidwhy.examples.showcase.functional.ajax;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import com.androidwhy.examples.showcase.functional.BaseSeleniumTestCase;

/**
 * 测试Ajax Mashup.
 * 
 * @Gordon
 */
public class AjaxFT extends BaseSeleniumTestCase {

	@Test
	public void mashup() {
		s.open("/");
		s.click(By.linkText("Web演示"));
		s.click(By.linkText("跨域名Mashup演示"));

		s.click(By.xpath("//input[@value='获取内容']"));
		s.waitForVisible(By.id("mashupContent"), 5000);
		assertEquals("Hello World!", s.getText(By.id("mashupContent")));
	}
}
