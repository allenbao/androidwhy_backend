package com.androidwhy.examples.basicservice.api;

import com.androidwhy.examples.basicservice.data.TaskData;
import com.androidwhy.examples.basicservice.entity.Task;
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
 * 
 * @author Gordon
 */
public class TaskRestFT {

	private final RestTemplate restTemplate = new RestTemplate();

	private final JsonMapper jsonMapper = new JsonMapper();

	private static class TaskList extends ArrayList<Task> {
	};

	private static String resoureUrl;

    private static String baseUrl = "http://localhost:9999";

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
		assertEquals(4, tasks.size());
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
}
