package com.androidwhy.examples.helloworld.functional.gui;

import com.androidwhy.examples.helloworld.data.TaskData;
import com.androidwhy.examples.helloworld.entity.Task;
import com.androidwhy.examples.helloworld.functional.BaseSeleniumTestCase;
import com.androidwhy.modules.test.category.Smoke;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 任务管理的功能测试, 测试页面JavaScript及主要用户故事流程.
 * 
 * @author Gordon
 */
public class TaskGuiFT extends BaseSeleniumTestCase {

	/**
	 * 浏览任务列表.
	 */
	@Test
	@Category(Smoke.class)
	public void viewTaskList() {
		s.open("/task/");
		WebElement table = s.findElement(By.id("contentTable"));
		assertEquals("Release SpringSide 4.0", s.getTable(table, 0, 0));
	}

	/**
	 * 创建并更新任务.
	 */
	@Test
	@Category(Smoke.class)
	public void createAndUpdateTask() {
		s.open("/task/");

		//create
		s.click(By.linkText("创建任务"));

		Task task = TaskData.randomTask();
		s.type(By.id("task_title"), task.getTitle());
		s.click(By.id("submit_btn"));

		assertTrue(s.isTextPresent("创建任务成功"));

		//update
		s.click(By.linkText(task.getTitle()));
		assertEquals(task.getTitle(), s.getValue(By.id("task_title")));

		String newTitle = TaskData.randomTitle();
		s.type(By.id("task_title"), newTitle);
		s.click(By.id("submit_btn"));
		assertTrue(s.isTextPresent("更新任务成功"));
	}

	@Test
	public void deleteTask() {
		s.open("/task/delete/2");
		assertTrue("没有成功消息", s.isTextPresent("删除任务成功"));
	}

	@Test
	public void inputInValidateValue() {
		s.open("/task/");
		s.click(By.linkText("创建任务"));
		s.click(By.id("submit_btn"));

		assertEquals("必选字段", s.getText(By.xpath("//fieldset/div/div/span")));
	}
}
