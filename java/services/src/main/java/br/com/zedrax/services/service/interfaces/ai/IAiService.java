package br.com.zedrax.services.service.interfaces.ai;

import java.util.List;

import br.com.zedrax.services.model.ai.AiData;

public interface IAiService {
	
	String[][] process(String matrix);
	List<AiData> convertUnrealDataToJavaData(String input);
	String[][] convertJavaDataToPythonMatrix(List<AiData> aiData);
	String[][] processWithJava(String[][] matrix);
	String[][] processWithPython(String[][] matrix);
}