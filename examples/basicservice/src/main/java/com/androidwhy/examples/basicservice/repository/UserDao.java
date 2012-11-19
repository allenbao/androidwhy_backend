package com.androidwhy.examples.basicservice.repository;

import com.androidwhy.examples.basicservice.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	User findByLoginName(String loginName);
}
