package br.com.zedrax.services.loader.settings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import br.com.zedrax.services.model.settings.SettingsAttributes;
import br.com.zedrax.services.model.settings.SettingsGroup;
import br.com.zedrax.services.repository.settings.SettingsAttributesRepository;
import br.com.zedrax.services.repository.settings.SettingsGroupRepository;

@Component("settingsAttributesLoader")
@Order(value = 4)
public class SettingsAttributesLoader implements ApplicationRunner {
	@Value("${settings.attribute.audio.music.description}")
	private String music;

	@Value("${settings.attribute.audio.sfx.description}")
	private String sfx;

	@Value("${settings.attribute.audio.speech.description}")
	private String speech;

	@Value("${settings.attribute.display.resolution.description}")
	private String resolution;

	@Value("${settings.attribute.audio.music.default_value}")
	private String musicDefaultValue;

	@Value("${settings.attribute.audio.sfx.default_value}")
	private String sfxDefaultValue;

	@Value("${settings.attribute.audio.speech.default_value}")
	private String speechDefaultValue;

	@Value("${settings.attribute.display.resolution.default_value}")
	private String resolutionDefaultValue;

	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(SettingsAttributesLoader.class);

	@Autowired
	private SettingsAttributesRepository repository;

	@Autowired
	private SettingsGroupRepository settingsGroupRepository;

	@Autowired
	private Environment environment;

	public void run(ApplicationArguments args) {
		List<SettingsAttributes> listFromDb = repository.findAll();
		List<SettingsAttributes> newList = new ArrayList<>();

		String audio = environment.getProperty("settings.group.audio");
		String display = environment.getProperty("settings.group.display");

		Map<String, SettingsGroup> settingsGroups = settingsGroupRepository.findAll().stream()
				.collect(Collectors.toMap(SettingsGroup::getGroup, Function.identity()));

		newList.add(new SettingsAttributes(music, musicDefaultValue, settingsGroups.get(audio)));
		newList.add(new SettingsAttributes(sfx, sfxDefaultValue, settingsGroups.get(audio)));
		newList.add(new SettingsAttributes(speech, speechDefaultValue, settingsGroups.get(audio)));
		newList.add(new SettingsAttributes(resolution, resolutionDefaultValue, settingsGroups.get(display)));

		newList.removeAll(listFromDb);

		repository.save(newList);
	}
}