package com.androidwhy.examples.helloworld.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.androidwhy.examples.helloworld.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	User findByLoginName(String loginName);
}
