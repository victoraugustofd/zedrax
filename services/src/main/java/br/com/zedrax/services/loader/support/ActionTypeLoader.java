package br.com.zedrax.services.loader.support;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.zedrax.services.model.support.ActionType;
import br.com.zedrax.services.repository.support.ActionTypeRepository;

@Component("actionTypeLoader")
@Order(value = 5)
public class ActionTypeLoader implements ApplicationRunner {

    @Value("${action.type.move}")
    private String move;

    @Value("${action.type.attack}")
    private String attack;

    @SuppressWarnings("unused")
    private final static Logger logger = Logger.getLogger(ActionTypeLoader.class);

    @Autowired
    private ActionTypeRepository repository;

    public void run(ApplicationArguments args) {

        List<ActionType> listFromDb = repository.findAll();
        List<ActionType> newList = new ArrayList<>();

        newList.add(new ActionType(move));
        newList.add(new ActionType(attack));

        newList.removeAll(listFromDb);

        repository.save(newList);
    }
}