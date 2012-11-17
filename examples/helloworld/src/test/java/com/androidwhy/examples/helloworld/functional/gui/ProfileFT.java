package com.androidwhy.examples.helloworld.functional.gui;

import com.androidwhy.examples.helloworld.functional.BaseSeleniumTestCase;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class ProfileFT extends BaseSeleniumTestCase {

	/**
	 *  修改用户资料.
	 */
	@Test
	public void editProfile() {
		s.open("/profile");
		s.type(By.id("name"), "Kevin");
		s.click(By.id("submit_btn"));

		assertTrue("没有成功消息", s.isTextPresent("Kevin"));
	}
}
