package br.com.zedrax.services.controller.settings;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zedrax.services.model.settings.SettingsGroup;
import br.com.zedrax.services.service.interfaces.settings.ISettingsService;
import br.com.zedrax.services.vo.settings.SettingsGroupVo;

@RestController("settingsController")
@RequestMapping(value = "/settings", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SettingsController {

	@Autowired
	private ISettingsService service;

	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(value = "/group", method = RequestMethod.GET)
	@ResponseBody
	public List<SettingsGroupVo> retrieveSettingsGroup() {
		return service.findAllGroups()
				.stream()
				.map(group -> convertEntityToVo(group))
				.collect(Collectors.toList());
	}

	private SettingsGroupVo convertEntityToVo(SettingsGroup entity) {
		return modelMapper.map(entity, SettingsGroupVo.class);
	}
}