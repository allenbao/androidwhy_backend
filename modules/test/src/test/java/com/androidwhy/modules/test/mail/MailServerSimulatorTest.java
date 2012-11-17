package com.androidwhy.modules.test.mail;

import com.androidwhy.modules.test.spring.SpringContextTestCase;
import com.icegreen.greenmail.util.GreenMail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = { "/applicationContext-test.xml" })
public class MailServerSimulatorTest extends SpringContextTestCase {

	@Autowired
	private GreenMail greenMail;

	@Test
	public void greenMail() {
		assertEquals(3025, greenMail.getSmtp().getPort());
	}
}
