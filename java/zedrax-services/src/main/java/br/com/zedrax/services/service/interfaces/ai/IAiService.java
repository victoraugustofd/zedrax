package br.com.zedrax.services.service.interfaces.ai;

public interface IAiService {
	
	String[][] process(String matrix);
	String[][] convertInputStringToMatrix(String input);
}