package br.com.zedrax.services.service.intf.account;

import br.com.zedrax.services.model.account.Account;

public interface AccountService
{
	Account findByEmail( String email );
	boolean createAccount( String email, Boolean emailInfoFlag, String name, String password );
	Account activateAccount( Account account );
}