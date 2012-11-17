package com.androidwhy.examples.helloworld.data;

import com.androidwhy.examples.helloworld.entity.User;
import com.androidwhy.modules.test.data.RandomData;

public class UserData {

	public static User randomNewUser() {
		User user = new User();
		user.setLoginName(RandomData.randomName("user"));
		user.setName(RandomData.randomName("User"));
		user.setPlainPassword(RandomData.randomName("password"));

		return user;
	}
}
