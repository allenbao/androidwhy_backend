package com.androidwhy.examples.showcase.repository.mybatis;

import com.androidwhy.examples.showcase.entity.Team;

/**
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * 
 * @author Gordon
 */
@MyBatisRepository
public interface TeamMybatisDao {

	Team getWithDetail(Long id);
}
