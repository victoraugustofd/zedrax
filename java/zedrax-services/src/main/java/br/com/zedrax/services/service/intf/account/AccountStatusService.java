package br.com.zedrax.services.service.intf.account;

import br.com.zedrax.services.model.account.AccountStatus;

public interface AccountStatusService
{
	AccountStatus findById( Long id );
	AccountStatus findByStatus( String status );
}