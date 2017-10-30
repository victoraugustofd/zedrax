package br.com.zedrax.services.repository.support;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zedrax.services.model.support.ActionType;

@Repository("actionTypeRepository")
public interface ActionTypeRepository extends JpaRepository<ActionType, Long> {

}