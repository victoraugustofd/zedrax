package br.com.zedrax.services.service.impl.ai;

import org.python.core.PyList;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zedrax.services.service.interfaces.ai.IAiService;

@Service("aiService")
public class AiService implements IAiService {

	@Autowired
	private PythonInterpreter pythonInterpreter;

	@SuppressWarnings("unchecked")
	@Override
	public String[] process(String[] matrixInput) {
		
		pythonInterpreter.execfile(getClass().getClassLoader().getResourceAsStream("ai/first_test.py"));
		
		pythonInterpreter.set("matrix", matrixInput);
		
		PyList matrixOutput = (PyList) pythonInterpreter.eval("Zedrax_Ai.process_ai(matrix)");
		
		return (String[]) matrixOutput.stream().toArray(String[]::new);
	}
}