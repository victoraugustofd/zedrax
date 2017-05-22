package br.com.zedrax.services.service.impl.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.zedrax.services.model.account.Account;
import br.com.zedrax.services.model.account.AccountStatus;
import br.com.zedrax.services.repository.account.AccountRepository;
import br.com.zedrax.services.service.intf.account.AccountService;
import br.com.zedrax.services.service.intf.account.AccountSettingsService;
import br.com.zedrax.services.service.intf.account.AccountStatusService;

@Service( "accountService" )
public class AccountServiceImpl implements AccountService
{
	@Autowired
	private AccountRepository repository;
	
	@Autowired
	private AccountSettingsService accountSettingsService;
	
	@Autowired
	private AccountStatusService accountStatusService;
	
	@Autowired
	private Environment environment;

	@Override
	public boolean createAccount( String email, Boolean emailInfoFlag, String name, String password )
	{
		AccountStatus accountStatus = accountStatusService
				  					  .findByStatus( environment.getProperty( "account_status.waiting_confirmation" ) );
		
		Account account = new Account( email, emailInfoFlag, name, password, accountStatus );
		
		repository.save( account );
		return false;
	}

	@Override
	public Account activateAccount( Account account )
	{
		AccountStatus accountStatus = accountStatusService
				  					  .findByStatus( environment.getProperty( "account_status.active" ) );
		
		account.setAccountStatus( accountStatus );
		
		repository.save( account );
		
		accountSettingsService.createAccountSettings( account );
		
		return account;
	}

	@Override
	public Account findByEmail( String email )
	{
		return repository.findByEmail( email );
	}
	
	
}