package com.androidwhy.examples.showcase.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.androidwhy.examples.showcase.entity.Role;

public interface RoleDao extends PagingAndSortingRepository<Role, Long> {

}
