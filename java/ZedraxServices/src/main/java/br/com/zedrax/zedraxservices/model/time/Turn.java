package br.com.zedrax.zedraxservices.model.time;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.zedrax.zedraxservices.model.piece.PieceTurn;
import br.com.zedrax.zedraxservices.model.user.User;

/**
 * The persistent class for the "turn" database table.
 * 
 */
@Entity
@Table( name = "\"turn\"" )
public class Turn implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_turn\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idTurn;
	
	@Column( name = "\"mana\"", nullable = false )
	private Integer mana;
	
	@ManyToOne( targetEntity = Round.class )
	@JoinColumn( name = "\"id_round\"", nullable = false )
	private Round round;
	
	@ManyToOne( targetEntity = User.class )
	@JoinColumn( name = "\"id_user\"", nullable = false )
	private User user;
	
	@OneToMany( mappedBy = "turn", targetEntity = TurnAction.class )
	private List< TurnAction > turnActions;
	
	@OneToMany( mappedBy = "turn", targetEntity = PieceTurn.class )
	private List< PieceTurn > pieceTurns;
	
	public Turn() {}
	
	public Long getIdTurn()
	{
		return this.idTurn;
	}
	
	public void setIdTurn( Long idTurn )
	{
		this.idTurn = idTurn;
	}
	
	public Integer getMana()
	{
		return this.mana;
	}
	
	public void setMana( Integer mana )
	{
		this.mana = mana;
	}
	
	public Round getRound()
	{
		return this.round;
	}
	
	public void setRound( Round round )
	{
		this.round = round;
	}
	
	public User getUser()
	{
		return this.user;
	}
	
	public void setUser( User user )
	{
		this.user = user;
	}
	
	public List< TurnAction > getTurnActions()
	{
		return this.turnActions;
	}
	
	public void setTurnActions( List< TurnAction > turnActions )
	{
		this.turnActions = turnActions;
	}
	
	public TurnAction addTurnAction( TurnAction turnAction )
	{
		getTurnActions().add( turnAction );
		turnAction.setTurn( this );
		
		return turnAction;
	}
	
	public TurnAction removeTurnAction( TurnAction turnAction )
	{
		getTurnActions().remove( turnAction );
		turnAction.setTurn( null );
		
		return turnAction;
	}
}