package br.com.zedrax.services.model.piece;
//OK
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
 * The persistent class for the "piece_type_class" database table.
 * 
 */
@Entity
@Table( name = "\"piece_type_class\"",
		uniqueConstraints = @UniqueConstraint( columnNames = "\"type_class\"" ) )
public class PieceTypeClass implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_piece_type_class\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idPieceTypeClass;
	
	@Column( name = "\"type_class\"", nullable = false )
	@Length( max = 10 )
	private String typeClass;
	
	@OneToMany( mappedBy = "pieceTypeClass", targetEntity = PieceType.class )
	private List< PieceType > pieceTypes;
	
	public PieceTypeClass() {}
	
	public PieceTypeClass( String typeClass )
	{
		setTypeClass( typeClass );
	}
	
	public Long getIdPieceTypeClass()
	{
		return this.idPieceTypeClass;
	}
	
	public void setIdPieceType( Long idPieceTypeClass )
	{
		this.idPieceTypeClass = idPieceTypeClass;
	}
	
	public String getTypeClass()
	{
		return this.typeClass;
	}
	
	public void setTypeClass( String typeClass )
	{
		this.typeClass = typeClass;
	}
	
	@Override
	public boolean equals( Object obj )
	{
		boolean equals = false;
		
		if ( obj != this )
		{
			if ( obj instanceof PieceTypeClass )
			{
				PieceTypeClass pieceType = ( PieceTypeClass ) obj;
				
				if ( Objects.equals( typeClass, pieceType.getTypeClass() ) )
					equals = true;
			}
		}
		
		return equals;
	}
}