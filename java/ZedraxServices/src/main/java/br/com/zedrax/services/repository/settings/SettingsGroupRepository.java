package br.com.zedrax.services.repository.settings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zedrax.services.model.settings.SettingsGroup;

@Repository( "settingsGroupRepository" )
public interface SettingsGroupRepository extends JpaRepository< SettingsGroup, Long >
{
	
}