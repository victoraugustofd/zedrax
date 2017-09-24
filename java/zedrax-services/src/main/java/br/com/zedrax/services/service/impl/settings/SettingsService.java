package br.com.zedrax.services.service.impl.settings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zedrax.services.model.settings.SettingsGroup;
import br.com.zedrax.services.repository.settings.SettingsAttributesRepository;
import br.com.zedrax.services.repository.settings.SettingsGroupRepository;
import br.com.zedrax.services.service.interfaces.settings.ISettingsService;

@Service("settingsService")
public class SettingsService implements ISettingsService {
	
	@Autowired
	private SettingsAttributesRepository attributesRepository;
	
	@Autowired
	private SettingsGroupRepository groupRepository;

	@Override
	public List<SettingsGroup> findAllGroups() {
		return groupRepository.findAll();
	}
}