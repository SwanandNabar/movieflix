package io.egen.app.service;

import java.util.List;

import io.egen.app.entity.AccountUser;

public interface AccountUserService {

	public List<AccountUser> findAll();

	public AccountUser findOne(String userId);

	public AccountUser create(AccountUser au);

	public AccountUser update(String userId, AccountUser au);

	public void remove(String userId);

}
