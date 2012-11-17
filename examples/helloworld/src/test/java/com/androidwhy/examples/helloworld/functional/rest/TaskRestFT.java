package com.androidwhy.examples.helloworld.functional.rest;

import com.androidwhy.examples.helloworld.data.TaskData;
import com.androidwhy.examples.helloworld.entity.Task;
import com.androidwhy.examples.helloworld.functional.BaseFunctionalTestCase;
import com.androidwhy.modules.mapper.JsonMapper;
import com.androidwhy.modules.test.category.Smoke;
import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * 任务管理的功能测试, 测试页面JavaScript及主要用户故事流程.
 * 
 * @author Gordon
 */
public class TaskRestFT extends BaseFunctionalTestCase {

	private final RestTemplate restTemplate = new RestTemplate();

	private final JsonMapper jsonMapper = new JsonMapper();

	private static class TaskList extends ArrayList<Task> {
	};

	private static String resoureUrl;

	@BeforeClass
	public static void initUrl() {
		resoureUrl = baseUrl + "/api/v1/task";
	}

	/**
	 * 查看任务列表.
	 */
	@Test
	@Category(Smoke.class)
	public void listTasks() {
		TaskList tasks = restTemplate.getForObject(resoureUrl, TaskList.class);
		assertEquals(5, tasks.size());
		assertEquals("Study PlayFramework 2.0", tasks.get(0).getTitle());
	}

	/**
	 * 获取任务.
	 */
	@Test
	@Category(Smoke.class)
	public void getTask() {
		Task task = restTemplate.getForObject(resoureUrl + "/{id}", Task.class, 1L);
		assertEquals("Study PlayFramework 2.0", task.getTitle());
	}

	/**
	 * 创建/更新/删除任务.
	 */
	@Test
	@Category(Smoke.class)
	public void createUpdateAndDeleteTask() {

		//create
		Task task = TaskData.randomTask();

		URI taskUri = restTemplate.postForLocation(resoureUrl, task);
		System.out.println(taskUri.toString());
		Task createdTask = restTemplate.getForObject(taskUri, Task.class);
		assertEquals(task.getTitle(), createdTask.getTitle());

		//update
		String id = StringUtils.substringAfterLast(taskUri.toString(), "/");
		task.setId(new Long(id));
		task.setTitle(TaskData.randomTitle());

		restTemplate.put(taskUri, task);

		Task updatedTask = restTemplate.getForObject(taskUri, Task.class);
		assertEquals(task.getTitle(), updatedTask.getTitle());

		//delete
		restTemplate.delete(taskUri);

		try {
			restTemplate.getForObject(taskUri, Task.class);
			fail("Get should fail while feth a deleted task");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		}
	}

	@Test
	public void invalidInput() {

		//create
		Task titleBlankTask = new Task();
		try {
			restTemplate.postForLocation(resoureUrl, titleBlankTask);
			fail("Create should fail while title is blank");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
			Map messages = jsonMapper.fromJson(e.getResponseBodyAsString(), Map.class);
			assertEquals(1, messages.size());
			assertEquals("may not be empty", messages.get("title"));
		}

		//update
		titleBlankTask.setId(1L);
		try {
			restTemplate.put(resoureUrl + "/1", titleBlankTask);
			fail("Update should fail while title is blank");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
			Map messages = jsonMapper.fromJson(e.getResponseBodyAsString(), Map.class);
			assertEquals(1, messages.size());
			assertEquals("may not be empty", messages.get("title"));
		}
	}
}
