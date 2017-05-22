package br.com.zedrax.services.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zedrax.services.model.account.AccountSettings;

@Repository( "accountSettingsRepository" )
public interface AccountSettingsRepository extends JpaRepository< AccountSettings, Long >
{
	
}