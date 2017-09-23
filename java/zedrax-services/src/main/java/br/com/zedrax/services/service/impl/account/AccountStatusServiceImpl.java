package br.com.zedrax.services.service.impl.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zedrax.services.model.account.AccountStatus;
import br.com.zedrax.services.repository.account.AccountStatusRepository;
import br.com.zedrax.services.service.intf.account.AccountStatusService;

@Service( "accountStatusService" )
public class AccountStatusServiceImpl implements AccountStatusService
{
	@Autowired
	private AccountStatusRepository repository;

	@Override
	public AccountStatus findById( Long id )
	{
		return repository.findById( id );
	}

	@Override
	public AccountStatus findByStatus( String status )
	{
		return repository.findByStatus( status );
	}
}