package br.com.zedrax.services.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zedrax.services.model.account.Account;

@Repository( "accountRepository" )
public interface AccountRepository extends JpaRepository< Account, Long >
{
	Account findByEmail( String email );
}