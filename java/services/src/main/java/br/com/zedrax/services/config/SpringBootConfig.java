package br.com.zedrax.services.config;

import java.util.Properties;

import org.modelmapper.ModelMapper;
import org.python.util.PythonInterpreter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("springBootConfig")
public class SpringBootConfig {

	@Bean(name = "modelMapper")
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}
	
	@Bean(name = "pythonInterpreter")
	public PythonInterpreter pythonInterpreter() {
		
		Properties properties = new Properties();
		
		properties.put("python.console.encoding", "UTF-8");
		properties.put("python.security.respectJavaAccessibility", "false");
		properties.put("python.import.site","false");

		Properties preproperties = System.getProperties();
				
		PythonInterpreter.initialize(preproperties, properties, new String[0]);
		
		return new PythonInterpreter();
	}
}