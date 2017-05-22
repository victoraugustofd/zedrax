package br.com.zedrax.services.model.piece;

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
 * The persistent class for the "piece_turn_status" database table.
 * 
 */
@Entity
@Table( name = "\"piece_turn_status\"",
		uniqueConstraints = @UniqueConstraint( columnNames = "\"status\"" ) )
public class PieceTurnStatus implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_piece_turn_status\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idPieceTurnStatus;
	
	@Column( name = "\"status\"", nullable = false )
	@Length( max = 45 )
	private String status;
	
	@OneToMany( mappedBy = "pieceTurnStatus", targetEntity = PieceTurn.class )
	private List< PieceTurn > pieceTurns;
	
	public PieceTurnStatus() {}
	
	public Long getIdPieceTurnStatus()
	{
		return this.idPieceTurnStatus;
	}
	
	public void setIdPieceTurnStatus( Long idPieceTurnStatus )
	{
		this.idPieceTurnStatus = idPieceTurnStatus;
	}
	
	public String getStatus()
	{
		return this.status;
	}
	
	public void setStatus( String status )
	{
		this.status = status;
	}
	
	public List< PieceTurn > getPieceTurns()
	{
		return pieceTurns;
	}
	
	public void setPieceTurns( List< PieceTurn > pieceTurn )
	{
		this.pieceTurns = pieceTurn;
	}
}