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

import br.com.zedrax.zedraxservices.model.game.Game;

/**
 * The persistent class for the "round" database table.
 * 
 */
@Entity
@Table( name = "\"round\"" )
public class Round implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_round\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idRound;
	
	@Column( name = "\"number\"", nullable = false )
	private Integer number;
	
	@ManyToOne( targetEntity = Game.class )
	@JoinColumn( name = "\"id_game\"", nullable = false )
	private Game game;
	
	@OneToMany( mappedBy = "round", targetEntity = Turn.class )
	private List< Turn > turns;
	
	public Round() {}
	
	public Long getIdRound()
	{
		return this.idRound;
	}
	
	public void setIdRound( Long idRound )
	{
		this.idRound = idRound;
	}
	
	public Integer getNumber()
	{
		return this.number;
	}
	
	public void setNumber( Integer number )
	{
		this.number = number;
	}
	
	public Game getGame()
	{
		return this.game;
	}
	
	public void setGame( Game game )
	{
		this.game = game;
	}
	
	public List< Turn > getTurns()
	{
		return this.turns;
	}
	
	public void setTurns( List< Turn > turns )
	{
		this.turns = turns;
	}
	
	public Turn addTurn( Turn turn )
	{
		getTurns().add( turn );
		turn.setRound( this );
		
		return turn;
	}
	
	public Turn removeTurn( Turn turn )
	{
		getTurns().remove( turn );
		turn.setRound( null );
		
		return turn;
	}
}