package com.androidwhy.modules.tools;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkersTest {
	private String TEMPLATE = "hello ${userName}";
	private String ERROR_TEMPLATE = "hello ${";

	@Test
	public void renderString() {
		Map<String, String> model = Maps.newHashMap();
		model.put("userName", "Gordon");
		String result = FreeMarkers.rendereString(TEMPLATE, model);
		assertEquals("hello Gordon", result);
	}

	@Test(expected = RuntimeException.class)
	public void renderStringWithErrorTemplate() {
		Map<String, String> model = Maps.newHashMap();
		model.put("userName", "Gordon");
		FreeMarkers.rendereString(ERROR_TEMPLATE, model);
	}

	@Test
	public void renderFile() throws IOException {
		Map<String, String> model = Maps.newHashMap();
		model.put("userName", "Gordon");
		Configuration cfg = FreeMarkers.buildConfiguration("classpath:/");
		Template template = cfg.getTemplate("testTemplate.ftl");
		String result = FreeMarkers.renderTemplate(template, model);
		assertEquals("hello Gordon", result);
	}
}
