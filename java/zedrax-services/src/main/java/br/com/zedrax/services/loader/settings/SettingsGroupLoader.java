package br.com.zedrax.services.loader.settings;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.zedrax.services.model.settings.SettingsGroup;
import br.com.zedrax.services.repository.settings.SettingsGroupRepository;

@Component("SettingsGroupLoader")
@Order(value = 3)
public class SettingsGroupLoader implements ApplicationRunner {
	@Value("${settings.group.audio}")
	private String audio;

	@Value("${settings.group.display}")
	private String display;

	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(SettingsGroupLoader.class);

	@Autowired
	private SettingsGroupRepository repository;

	public void run(ApplicationArguments args) {
		List<SettingsGroup> listFromDb = repository.findAll();
		List<SettingsGroup> newList = new ArrayList<>();

		newList.add(new SettingsGroup(audio));
		newList.add(new SettingsGroup(display));

		newList.removeAll(listFromDb);

		repository.save(newList);
	}
}