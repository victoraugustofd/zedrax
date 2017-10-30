package br.com.zedrax.services.service.interfaces.ai;

import java.util.List;

import br.com.zedrax.services.model.ai.AiAction;
import br.com.zedrax.services.model.ai.AiActionUnreal;
import br.com.zedrax.services.model.ai.AiData;

public interface IAiService {

    List<AiActionUnreal> process(String matrix);

    List<AiData> convertUnrealDataToJavaData(String input);

    List<AiAction> processWithJava(List<AiData> aiData);
}