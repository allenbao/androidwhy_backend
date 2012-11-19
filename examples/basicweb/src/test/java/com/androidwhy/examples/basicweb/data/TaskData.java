package com.androidwhy.examples.basicweb.data;

import com.androidwhy.examples.basicweb.entity.Task;
import com.androidwhy.examples.basicweb.entity.User;
import com.androidwhy.modules.test.data.RandomData;

/**
 * Task相关实体测试数据生成.
 * 
 * @author Gordon
 */
public class TaskData {

	public static Task randomTask() {
		Task task = new Task();
		task.setTitle(randomTitle());
		User user = new User(1L);
		task.setUser(user);
		return task;
	}

	public static String randomTitle() {
		return RandomData.randomName("Task");
	}
}
