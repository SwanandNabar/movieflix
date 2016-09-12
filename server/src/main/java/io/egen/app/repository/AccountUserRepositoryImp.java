package io.egen.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.app.entity.AccountUser;

@Repository
public class AccountUserRepositoryImp implements AccountUserRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<AccountUser> findAll(){
		TypedQuery<AccountUser> query = em.createNamedQuery("AccountUser.findAll", AccountUser.class);
		return query.getResultList();
	}
	
	@Override
	public AccountUser create (AccountUser au){
		em.persist(au);
		return au;
	}
	
	@Override
	public AccountUser findOne (String userId){
		
		return em.find(AccountUser.class, userId);
	}
	
	@Override
	public AccountUser update(String userId , AccountUser au){
		return em.merge(au);
	}
	
	@Override
	public AccountUser findByEmail(String email){
		TypedQuery<AccountUser> query = em.createNamedQuery("AccountUser.findByEmail", AccountUser.class);
		query.setParameter("pEmail", email);
		List<AccountUser> users = query.getResultList();
		if (users.size()==1){
			return users.get(0);
		}
		else{
			return null;
		}
	}
	
	@Override
	public void delete(AccountUser existing){
		em.remove(existing);
	}
	

}
