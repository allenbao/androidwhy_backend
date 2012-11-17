/**
 * Copyright (c) 2009-2012 androidwhy.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.androidwhy.modules.test.spring;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Spring的支持依赖注入的JUnit4 集成测试基类, 相比Spring原基类名字更短.
 * 
 * 子类需要定义applicationContext文件的位置,如:
 * @ContextConfiguration(locations = { "/applicationContext-test.xml" })
 * 
 * @author Gordon
 */
@ActiveProfiles("test")
public abstract class SpringContextTestCase extends AbstractJUnit4SpringContextTests {
}
