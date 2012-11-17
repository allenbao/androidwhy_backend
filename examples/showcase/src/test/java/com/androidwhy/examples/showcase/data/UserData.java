package com.androidwhy.examples.showcase.data;

import com.androidwhy.examples.showcase.entity.Role;
import com.androidwhy.examples.showcase.entity.User;
import com.androidwhy.modules.test.data.RandomData;

/**
 * 用户测试数据生成.
 * 
 * @author Gordon
 */
public class UserData {

	public static User randomUser() {
		String userName = RandomData.randomName("User");

		User user = new User();
		user.setLoginName(userName);
		user.setName(userName);
		user.setPlainPassword("123456");
		user.setEmail(userName + "@androidwhy.com");

		return user;
	}

	public static User randomUserWithAdminRole() {
		User user = UserData.randomUser();
		Role adminRole = UserData.adminRole();
		user.getRoleList().add(adminRole);
		return user;
	}

	public static Role adminRole() {
		Role role = new Role();
		role.setId(1L);
		role.setName("Admin");

		return role;
	}
}
