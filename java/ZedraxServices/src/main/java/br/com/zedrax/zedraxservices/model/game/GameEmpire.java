package br.com.zedrax.zedraxservices.model.game;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Length;

import br.com.zedrax.zedraxservices.model.empire.Empire;

/**
 * The persistent class for the "game_empire" database table.
 * 
 */
@Entity
@Table( name = "\"game_empire\"" )
public class GameEmpire implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_game_empire\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idGameEmpire;
	
	@Column( name = "\"captured_pieces\"", nullable = false )
	private Integer capturedPieces;
	
	@Column( name = "\"ip\"", nullable = false )
	@Length( max = 15 )
	private String ip;
	
	@Column( name = "\"lost_pieces\"", nullable = false )
	private Integer lostPieces;
	
	@Column( name = "\"winner\"", nullable = false )
	private Boolean winner;
	
	@Column( name = "\"xp_gained\"", nullable = false )
	@Digits( integer = 10, fraction = 2 )
	private BigDecimal xpGained;
	
	@ManyToOne( targetEntity = Game.class )
	@JoinColumn( name = "\"id_game\"", nullable = false )
	private Game game;
	
	@ManyToOne( targetEntity = Empire.class )
	@JoinColumn( name = "\"id_empire\"", nullable = false )
	private Empire empire;
	
	public GameEmpire() {}
	
	public Long getIdGameEmpire()
	{
		return idGameEmpire;
	}
	
	public void setIdGameEmpire( Long idGameEmpire )
	{
		this.idGameEmpire = idGameEmpire;
	}
	
	public Integer getCapturedPieces()
	{
		return capturedPieces;
	}
	
	public void setCapturedPieces( Integer capturedPieces )
	{
		this.capturedPieces = capturedPieces;
	}
	
	public String getIp()
	{
		return ip;
	}
	
	public void setIp( String ip )
	{
		this.ip = ip;
	}
	
	public Integer getLostPieces()
	{
		return lostPieces;
	}
	
	public void setLostPieces( Integer lostPieces )
	{
		this.lostPieces = lostPieces;
	}
	
	public Boolean getWinner()
	{
		return winner;
	}
	
	public void setWinner( Boolean winner )
	{
		this.winner = winner;
	}
	
	public BigDecimal getXpGained()
	{
		return xpGained;
	}
	
	public void setXpGained( BigDecimal xpGained )
	{
		this.xpGained = xpGained;
	}
	
	public Game getGame()
	{
		return game;
	}
	
	public void setGame( Game game )
	{
		this.game = game;
	}
	
	public Empire getEmpire()
	{
		return empire;
	}
	
	public void setEmpire( Empire empire )
	{
		this.empire = empire;
	}
}