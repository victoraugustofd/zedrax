package br.com.zedrax.services.service.interfaces.settings;

import java.util.List;

import br.com.zedrax.services.model.settings.SettingsGroup;

public interface ISettingsService {

    List<SettingsGroup> findAllGroups();
}