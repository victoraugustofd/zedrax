package br.com.zedrax.services.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.zedrax.services.model.account.Account;
import br.com.zedrax.services.service.intf.account.AccountService;

@RestController( "accountController" )
public class AccountController
{
	@Autowired
	private AccountService service;
	
	@RequestMapping( value = "createAccount", method = RequestMethod.GET )
	public boolean createAccount( @RequestParam( "email" ) String email,
								  @RequestParam( "emailInfoFlag" ) Boolean emailInfoFlag,
								  @RequestParam( "name" ) String name,
								  @RequestParam( "password" ) String password )
	{
		boolean success = false;
		
		success = service.createAccount( email, emailInfoFlag, name, password );
		
		return success;
	}
	
	@RequestMapping( value = "activateAccount", method = RequestMethod.GET )
	public boolean activateAccount( @RequestParam( "email" ) String email )
	{
		Account account = service.findByEmail( email );
		service.activateAccount( account );
		
		return false;
	}
}