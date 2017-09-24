package br.com.zedrax.services.service.impl.settings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zedrax.services.model.settings.SettingsAttributes;
import br.com.zedrax.services.repository.settings.SettingsAttributesRepository;
import br.com.zedrax.services.service.interfaces.settings.ISettingsAttributesService;

@Service("settingsAttributesService")
public class SettingsAttributesService implements ISettingsAttributesService {
	@Autowired
	private SettingsAttributesRepository repository;

	@Override
	public List<SettingsAttributes> findAll() {
		return repository.findAll();
	}
}