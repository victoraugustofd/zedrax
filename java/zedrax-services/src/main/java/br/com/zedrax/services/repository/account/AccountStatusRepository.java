package br.com.zedrax.services.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zedrax.services.model.account.AccountStatus;

@Repository( "accountStatusRepository" )
public interface AccountStatusRepository extends JpaRepository< AccountStatus, Long >
{
	AccountStatus findById( Long id );
	AccountStatus findByStatus( String status );
}