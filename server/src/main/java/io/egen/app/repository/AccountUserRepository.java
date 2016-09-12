package io.egen.app.repository;

import java.util.List;

import io.egen.app.entity.AccountUser;

public interface AccountUserRepository {

	public List<AccountUser> findAll();

	public AccountUser create(AccountUser au);

	public AccountUser findOne(String userId);

	public AccountUser update(String userId, AccountUser au);

	public AccountUser findByEmail(String email);

	public void delete(AccountUser existing);

}
