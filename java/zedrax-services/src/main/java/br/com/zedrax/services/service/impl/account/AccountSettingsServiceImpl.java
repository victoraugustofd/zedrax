package br.com.zedrax.services.service.impl.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.zedrax.services.model.account.Account;
import br.com.zedrax.services.model.account.AccountSettings;
import br.com.zedrax.services.model.settings.SettingsAttributes;
import br.com.zedrax.services.repository.account.AccountSettingsRepository;
import br.com.zedrax.services.service.intf.account.AccountSettingsService;
import br.com.zedrax.services.service.intf.settings.SettingsAttributesService;

@Service( "accountSettingsService" )
public class AccountSettingsServiceImpl implements AccountSettingsService
{
	@Autowired
	private AccountSettingsRepository repository;
	
	@Autowired
	private SettingsAttributesService settingsAttributesService;
	
	@Autowired
	private Environment environment;
	
	@Override
	public boolean createAccountSettings( Account account )
	{
		List< AccountSettings > list = new ArrayList<>();
		
		Map< String, SettingsAttributes > mapOfSettings = settingsAttributesService
														  .findAll()
														  .stream()
														  .collect( Collectors.toMap( SettingsAttributes::getAttribute, object -> object ) );
		
		SettingsAttributes music = mapOfSettings.get( environment.getProperty( "settings.attribute.audio.music.description" ) );
		SettingsAttributes sfx = mapOfSettings.get( environment.getProperty( "settings.attribute.audio.sfx.description" ) );
		SettingsAttributes speech = mapOfSettings.get( environment.getProperty( "settings.attribute.audio.speech.description" ) );
		SettingsAttributes resolution = mapOfSettings.get( environment.getProperty( "settings.attribute.display.resolution.description" ) );
		
		list.add( new AccountSettings( account, music, music.getDefaultValue() ) );
		list.add( new AccountSettings( account, sfx, sfx.getDefaultValue() ) );
		list.add( new AccountSettings( account, speech, speech.getDefaultValue() ) );
		list.add( new AccountSettings( account, resolution, resolution.getDefaultValue() ) );
		
		repository.save( list );
		
		return false;
	}
}