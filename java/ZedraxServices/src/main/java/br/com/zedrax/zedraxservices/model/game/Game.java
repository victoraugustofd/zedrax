package br.com.zedrax.zedraxservices.model.game;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.zedrax.zedraxservices.model.support.Battlefield;
import br.com.zedrax.zedraxservices.model.time.Round;

/**
 * The persistent class for the "game" database table.
 * 
 */
@Entity
@Table( name = "\"game\"" )
public class Game implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_game\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idGame;
	
	@Temporal( TemporalType.DATE )
	@Column( name = "\"dt_start\"", nullable = false )
	private Date dtStart;
	
	@Temporal( TemporalType.DATE )
	@Column( name = "\"dt_end\"", nullable = false )
	private Date dtEnd;
	
	@ManyToOne( targetEntity = Battlefield.class )
	@JoinColumn( name = "\"id_battlefield\"", nullable = false )
	private Battlefield battlefield;
	
	@ManyToOne( targetEntity = GameStatus.class )
	@JoinColumn( name = "\"id_game_status\"", nullable = false )
	private GameStatus gameStatus;
	
	@OneToMany( mappedBy = "game", targetEntity = GameEmpire.class )
	private List< GameEmpire > gameEmpires;
	
	@OneToMany( mappedBy = "game", targetEntity = Round.class )
	private List< Round > rounds;
	
	public Game() {}
	
	public Long getIdGame()
	{
		return idGame;
	}
	
	public void setIdGame( Long idGame )
	{
		this.idGame = idGame;
	}
	
	public Date getDtStart()
	{
		return dtStart;
	}
	
	public void setDtStart( Date dtStart )
	{
		this.dtStart = dtStart;
	}
	
	public Date getDtEnd()
	{
		return dtEnd;
	}
	
	public void setDtEnd( Date dtEnd )
	{
		this.dtEnd = dtEnd;
	}
	
	public Battlefield getBattlefield()
	{
		return battlefield;
	}
	
	public void setBattlefield( Battlefield battlefield )
	{
		this.battlefield = battlefield;
	}
	
	public GameStatus getGameStatus()
	{
		return gameStatus;
	}
	
	public void setGameStatus( GameStatus gameStatus )
	{
		this.gameStatus = gameStatus;
	}
	
	public List< GameEmpire > getGameEmpires()
	{
		return gameEmpires;
	}
	
	public void setGameEmpires( List< GameEmpire > gameEmpires )
	{
		this.gameEmpires = gameEmpires;
	}
	
	public List< Round > getRounds()
	{
		return rounds;
	}
	
	public void setRounds( List< Round > rounds )
	{
		this.rounds = rounds;
	}
}