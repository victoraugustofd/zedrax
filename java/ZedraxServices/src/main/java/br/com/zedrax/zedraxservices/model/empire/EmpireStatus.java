package br.com.zedrax.zedraxservices.model.empire;

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
@Table( name = "\"empire_status\"",
		uniqueConstraints = @UniqueConstraint( columnNames = "\"status\"" ) )
public class EmpireStatus implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_empire_status\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idEmpireStatus;
	
	@Column( name = "\"status\"", nullable = false )
	@Length( max = 45 )
	private String status;
	
	@OneToMany( mappedBy = "empireStatus", targetEntity = Empire.class )
	private List< Empire > empires;
	
	public EmpireStatus() {}
	
	public Long getIdEmpireStatus()
	{
		return idEmpireStatus;
	}
	
	public void setIdEmpireStatus( Long idEmpireStatus )
	{
		this.idEmpireStatus = idEmpireStatus;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus( String status )
	{
		this.status = status;
	}
	
	public List< Empire > getEmpires()
	{
		return empires;
	}
	
	public void setEmpires( List< Empire > empires )
	{
		this.empires = empires;
	}
}