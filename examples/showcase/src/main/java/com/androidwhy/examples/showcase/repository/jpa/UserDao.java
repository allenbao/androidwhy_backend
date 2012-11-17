package com.androidwhy.examples.showcase.repository.jpa;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.androidwhy.examples.showcase.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {

	User findByName(String name);

	User findByLoginName(String loginName);
}
