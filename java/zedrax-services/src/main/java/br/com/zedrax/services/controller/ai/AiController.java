package br.com.zedrax.services.controller.ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zedrax.services.service.interfaces.ai.IAiService;

@RestController("aiController")
@RequestMapping(value = "/ai", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AiController {
	@Autowired
	private IAiService service;

	@RequestMapping(value = "/process", method = RequestMethod.GET)
	@ResponseBody
	public String[] processZedraxAi(@RequestParam("matrix[]") String[] matrix) {
		
		return service.process(matrix);
	}
}