package com.yang.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepsitory implements UserRepository {

	@Override
	public void save() {
		System.out.println("UserJdbcRepsitory save...");
	}

}
