package com.yang.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yang.annotation.TestObject;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired(required=false)
	private TestObject testObject;
	@Override
	public void save() {
		System.out.println("UserReponstory save...");
		System.out.println(testObject);
	}

}
