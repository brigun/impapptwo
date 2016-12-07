package com.brigun.code.imp.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brigun.code.imp.models.User;


@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer>
{
	User findByUsername(String username);
	
	User findByUserId(long userId);
	
	List<User> findAll();
}
