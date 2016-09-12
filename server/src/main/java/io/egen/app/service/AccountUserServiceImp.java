package io.egen.app.service;

import java.util.List;


import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.app.entity.AccountUser;
import io.egen.app.exception.EntityAlreadyExistsException;
import io.egen.app.repository.AccountUserRepository;


@Service
public class AccountUserServiceImp implements AccountUserService {

	@Autowired
	private AccountUserRepository repository;
	
	@Override
	public List<AccountUser> findAll() {
		
		return repository.findAll();
	}

	@Override
	public AccountUser findOne(String userId) {
		AccountUser au = repository.findOne(userId);
		if (au == null){
			throw new EntityNotFoundException("User does not exist");
		}
		return au;
	}

	@Transactional
	@Override
	public AccountUser create(AccountUser au) {
		AccountUser exists = repository.findByEmail(au.getEmail());
		if (exists != null){
			throw new EntityAlreadyExistsException("User already exists");
		}
		return repository.create(au);
	}

	@Transactional
	@Override
	public AccountUser update(String userId, AccountUser au) {
		AccountUser exists = repository.findOne(userId);
		if (exists == null){
			throw new EntityNotFoundException("User not found");
		}
		return repository.update(userId, au);
	}

	@Transactional
	@Override
	public void remove(String userId) {
		AccountUser exists = repository.findOne(userId);
		if (exists == null){
			throw new EntityNotFoundException("No such User");
		}
		 repository.delete(exists);
		
	}

}
