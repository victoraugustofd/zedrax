package br.com.zedrax.services.model.game;

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

/**
 * The persistent class for the "game_status" database table.
 * 
 */
@Entity
@Table( name = "\"game_status\"",
		uniqueConstraints = @UniqueConstraint( columnNames = "\"status\"" ) )
public class GameStatus implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_game_status\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idGameStatus;
	
	@Column( name = "\"status\"", nullable = false )
	@Length( max = 45 )
	private String status;
	
	@OneToMany( mappedBy = "gameStatus", targetEntity = Game.class )
	private List< Game > games;
	
	public GameStatus() {}
	
	public String getStatus()
	{
		return this.status;
	}
	
	public void setStatus( String status )
	{
		this.status = status;
	}
	
	public Long getIdGameStatus()
	{
		return this.idGameStatus;
	}
	
	public void setIdGameStatus( Long idGameStatus )
	{
		this.idGameStatus = idGameStatus;
	}

	public List< Game > getGames()
	{
		return games;
	}

	public void setGames( List< Game > games )
	{
		this.games = games;
	}
}