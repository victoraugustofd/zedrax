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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;

/**
 * The persistent class for the "piece_type" database table.
 * 
 */
@Entity
@Table(name = "\"piece_type\"", uniqueConstraints = @UniqueConstraint(columnNames = "\"type\""))
public class PieceType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"id_piece_type\"", nullable = false, insertable = false, updatable = false)
	private Long idPieceType;

	@Column(name = "\"type\"", nullable = false)
	@Length(max = 10)
	private String type;

	@ManyToOne(targetEntity = PieceTypeClass.class)
	@JoinColumn(name = "\"id_piece_type_class\"", nullable = false)
	private PieceTypeClass pieceTypeClass;

	@OneToMany(mappedBy = "pieceType", targetEntity = Piece.class)
	private List<Piece> piece;

	public PieceType() {
	}

	public PieceType(String type, PieceTypeClass pieceTypeClass) {
		setType(type);
		setPieceTypeClass(pieceTypeClass);
	}

	public Long getIdPieceType() {
		return this.idPieceType;
	}

	public void setIdPieceType(Long idPieceType) {
		this.idPieceType = idPieceType;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public PieceTypeClass getPieceTypeClass() {
		return pieceTypeClass;
	}

	public void setPieceTypeClass(PieceTypeClass pieceTypeClass) {
		this.pieceTypeClass = pieceTypeClass;
	}

	@Override
	public boolean equals(Object obj) {
		boolean equals = false;

		if (obj != this) {
			if (obj instanceof PieceType) {
				PieceType pieceType = (PieceType) obj;

				if (Objects.equals(type, pieceType.getType()))
					equals = true;
			}
		}

		return equals;
	}
}