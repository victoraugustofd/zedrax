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

import br.com.zedrax.zedraxservices.model.game.Game;

/**
 * The persistent class for the "battlefield" database table.
 * 
 */
@Entity
@Table( name = "\"battlefield\"",
		uniqueConstraints = @UniqueConstraint( columnNames = "\"name\"" ) )
public class Battlefield implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_battlefield\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idBattlefield;
	
	@Column( name = "\"name\"", nullable = false )
	@Length( max = 100 )
	private String name;
	
	@OneToMany( mappedBy = "battlefield", targetEntity = Game.class )
	private List< Game > games;
	
	public Battlefield() {}
	
	public Long getIdBattlefield()
	{
		return this.idBattlefield;
	}
	
	public void setIdBattlefield( Long idBattlefield )
	{
		this.idBattlefield = idBattlefield;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName( String name )
	{
		this.name = name;
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