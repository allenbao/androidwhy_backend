package com.androidwhy.examples.showcase.repository.mybatis;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import com.androidwhy.examples.showcase.data.UserData;
import com.androidwhy.examples.showcase.entity.User;
import com.androidwhy.modules.test.spring.SpringTransactionalTestCase;

import com.google.common.collect.Maps;

@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class UserMybatisDaoTest extends SpringTransactionalTestCase {

	@Autowired
	private UserMybatisDao userDao;

	@Test
	public void getUser() throws Exception {
		User user = userDao.get(1L);
		assertEquals("admin", user.getLoginName());
	}

	@Test
	public void searchUser() throws Exception {
		Map<String, Object> parameter = Maps.newHashMap();
		parameter.put("name", "Admin");
		List<User> result = userDao.search(parameter);
		assertEquals(1, result.size());
		assertEquals("admin", result.get(0).getLoginName());
	}

	@Test
	public void createAndDeleteUser() throws Exception {
		//create
		int count = countRowsInTable("aw_user");
		User user = UserData.randomUser();
		userDao.save(user);
		Long id = user.getId();

		assertEquals(count + 1, countRowsInTable("aw_user"));
		User result = userDao.get(id);
		assertEquals(user.getLoginName(), result.getLoginName());

		//delete
		userDao.delete(id);
		assertEquals(count, countRowsInTable("aw_user"));
		assertNull(userDao.get(id));
	}

}
