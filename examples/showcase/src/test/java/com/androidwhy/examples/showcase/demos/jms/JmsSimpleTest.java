package com.androidwhy.examples.showcase.demos.jms;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import com.androidwhy.examples.showcase.demos.jms.simple.NotifyMessageListener;
import com.androidwhy.examples.showcase.demos.jms.simple.NotifyMessageProducer;
import com.androidwhy.examples.showcase.entity.User;
import com.androidwhy.modules.test.category.UnStable;
import com.androidwhy.modules.test.log.Log4jMockAppender;
import com.androidwhy.modules.test.spring.SpringContextTestCase;
import com.androidwhy.modules.utils.Threads;

@Category(UnStable.class)
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml", "/jms/applicationContext-jms-simple.xml" })
public class JmsSimpleTest extends SpringContextTestCase {

	@Autowired
	private NotifyMessageProducer notifyMessageProducer;

	@Test
	public void queueMessage() {
		Threads.sleep(1000);
		Log4jMockAppender appender = new Log4jMockAppender();
		appender.addToLogger(NotifyMessageListener.class);

		User user = new User();
		user.setName("Gordon");
		user.setEmail("Gordon@sringside.org.cn");

		notifyMessageProducer.sendQueue(user);
		logger.info("sended message");

		Threads.sleep(1000);
		assertEquals("UserName:Gordon, Email:Gordon@sringside.org.cn", appender.getFirstMessage());
	}

	@Test
	public void topicMessage() {
		Threads.sleep(1000);
		Log4jMockAppender appender = new Log4jMockAppender();
		appender.addToLogger(NotifyMessageListener.class);

		User user = new User();
		user.setName("Gordon");
		user.setEmail("Gordon@sringside.org.cn");

		notifyMessageProducer.sendTopic(user);
		logger.info("sended message");

		Threads.sleep(1000);
		assertEquals("UserName:Gordon, Email:Gordon@sringside.org.cn", appender.getFirstMessage());
	}
}
