package com.androidwhy.examples.basicweb.repository;

import com.androidwhy.examples.basicweb.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	User findByLoginName(String loginName);
}
