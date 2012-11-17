package com.androidwhy.examples.quickstart.repository;

import com.androidwhy.examples.quickstart.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	User findByLoginName(String loginName);
}
