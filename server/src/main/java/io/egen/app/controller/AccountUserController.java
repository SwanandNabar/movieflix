package io.egen.app.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.app.entity.AccountUser;
import io.egen.app.service.AccountUserService;

@RestController
@RequestMapping(value = "useraccount", produces = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AccountUserController {
	
	@Autowired
	private AccountUserService service;
	
	@RequestMapping(method= RequestMethod.GET)
	public List<AccountUser> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET , value="{id}")
	public AccountUser findOne(@PathVariable("id") String userId){
		return service.findOne(userId);
	}
	
	@RequestMapping(method=RequestMethod.POST ,consumes = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public AccountUser create (@RequestBody AccountUser au){
		return service.create(au);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="{id}" , consumes = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public AccountUser update (@PathVariable("id") String userId, @RequestBody AccountUser au){
		return service.update(userId, au);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="{id}")
	public void delete(@PathVariable("id") String userId){
		service.remove(userId);
		
	}	

}
