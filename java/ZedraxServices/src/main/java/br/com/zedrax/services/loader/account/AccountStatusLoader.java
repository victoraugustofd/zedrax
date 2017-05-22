package br.com.zedrax.services.loader.account;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.zedrax.services.model.account.AccountStatus;
import br.com.zedrax.services.repository.account.AccountStatusRepository;

@Component
public class AccountStatusLoader implements ApplicationRunner
{
	@Value( "${account_status.waiting_confirmation}" )
	private String waitingConfirmation;
	
	@Value( "${account_status.active}" )
	private String active;
	
	@Value( "${account_status.inactive}" )
	private String inactive;
	
	@Value( "${account_status.blocked}" )
	private String blocked;
	
	@Value( "${account_status.deleted}" )
	private String deleted;
	
	@SuppressWarnings( "unused" )
	private final static Logger logger = Logger.getLogger( AccountStatusLoader.class );
	
	@Autowired
	private AccountStatusRepository repository;
	
	public void run( ApplicationArguments args )
	{
		List< AccountStatus > listFromDb = repository.findAll();
		List< AccountStatus > newList = new ArrayList<>();
		
		newList.add( new AccountStatus( waitingConfirmation ) );
		newList.add( new AccountStatus( active ) );
		newList.add( new AccountStatus( inactive ) );
		newList.add( new AccountStatus( blocked ) );
		newList.add( new AccountStatus( deleted ) );
		
		newList.removeAll( listFromDb );
		
		repository.save( newList );
	}
}