package br.com.zedrax.zedraxservices.model.support;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;

import br.com.zedrax.zedraxservices.model.time.TurnAction;

/**
 * The persistent class for the "action_type" database table.
 * 
 */
@Entity
@Table( name = "\"action_type\"",
		uniqueConstraints = @UniqueConstraint( columnNames = "\"type\"" ) )
public class ActionType implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_action_type\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idActionType;
	
	@Column( name = "\"type\"", nullable = false )
	@Length( max = 100 )
	private String type;
	
	@OneToMany( mappedBy = "actionType", targetEntity = TurnAction.class )
	private List< TurnAction > turnActions;
	
	public ActionType() {}
	
	public String getType()
	{
		return type;
	}
	
	public void setType( String type )
	{
		this.type = type;
	}
	
	public Long getIdActionType()
	{
		return this.idActionType;
	}
	
	public void setIdActionType( Long idActionType )
	{
		this.idActionType = idActionType;
	}
	
	public List< TurnAction > getTurnActions()
	{
		return turnActions;
	}
	
	public void setTurnActions( List< TurnAction > turnActions )
	{
		this.turnActions = turnActions;
	}
}