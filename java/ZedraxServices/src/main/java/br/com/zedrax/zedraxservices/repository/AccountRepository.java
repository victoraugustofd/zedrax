package br.com.zedrax.zedraxservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zedrax.zedraxservices.model.account.Account;

public interface AccountRepository extends JpaRepository< Account, Long >
{
	
}