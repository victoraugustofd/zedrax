package br.com.zedrax.services.service.intf.settings;

import java.util.List;

import br.com.zedrax.services.model.settings.SettingsAttributes;

public interface SettingsAttributesService
{
	List< SettingsAttributes > findAll();
}