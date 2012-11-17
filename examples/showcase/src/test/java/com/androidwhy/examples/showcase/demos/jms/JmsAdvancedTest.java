package com.androidwhy.examples.showcase.demos.jms;

import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import com.androidwhy.examples.showcase.demos.jms.advanced.AdvancedNotifyMessageListener;
import com.androidwhy.examples.showcase.demos.jms.advanced.AdvancedNotifyMessageProducer;
import com.androidwhy.examples.showcase.entity.User;
import com.androidwhy.modules.test.category.UnStable;
import com.androidwhy.modules.test.log.Log4jMockAppender;
import com.androidwhy.modules.test.spring.SpringContextTestCase;
import com.androidwhy.modules.utils.Threads;

@Category(UnStable.class)
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml", "/jms/applicationContext-jms-advanced.xml" })
public class JmsAdvancedTest extends SpringContextTestCase {

	@Autowired
	private AdvancedNotifyMessageProducer notifyMessageProducer;

	@Resource
	private JmsTemplate advancedJmsTemplate;

	@Resource
	private Destination advancedNotifyTopic;

	@Test
	public void queueMessage() {
		Threads.sleep(1000);
		Log4jMockAppender appender = new Log4jMockAppender();
		appender.addToLogger(AdvancedNotifyMessageListener.class);

		User user = new User();
		user.setName("Gordon");
		user.setEmail("Gordon@sringside.org.cn");

		notifyMessageProducer.sendQueue(user);
		Threads.sleep(1000);
		assertEquals("UserName:Gordon, Email:Gordon@sringside.org.cn, ObjectType:user", appender.getFirstMessage());
	}

	@Test
	public void topicMessage() {
		Threads.sleep(1000);
		Log4jMockAppender appender = new Log4jMockAppender();
		appender.addToLogger(AdvancedNotifyMessageListener.class);

		User user = new User();
		user.setName("Gordon");
		user.setEmail("Gordon@sringside.org.cn");

		notifyMessageProducer.sendTopic(user);
		Threads.sleep(1000);
		assertEquals("UserName:Gordon, Email:Gordon@sringside.org.cn, ObjectType:user", appender.getFirstMessage());
	}

	@Test
	public void topicMessageWithWrongType() {
		Threads.sleep(1000);
		Log4jMockAppender appender = new Log4jMockAppender();
		appender.addToLogger(AdvancedNotifyMessageListener.class);

		advancedJmsTemplate.send(advancedNotifyTopic, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {

				MapMessage message = session.createMapMessage();
				message.setStringProperty("objectType", "role");
				return message;
			}
		});

		Threads.sleep(1000);
		assertTrue(appender.isEmpty());
	}
}
