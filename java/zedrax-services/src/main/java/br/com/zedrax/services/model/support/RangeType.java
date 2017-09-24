package br.com.zedrax.services.model.support;

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

import br.com.zedrax.services.model.piece.PieceRange;

/**
 * The persistent class for the "range_type" database table.
 * 
 */
@Entity
@Table(name = "\"range_type\"", uniqueConstraints = @UniqueConstraint(columnNames = "\"type\""))
public class RangeType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"id_range_type\"", nullable = false, insertable = false, updatable = false)
	private Long idRangeType;

	@Column(name = "\"type\"", nullable = false)
	@Length(max = 50)
	private String type;

	@OneToMany(mappedBy = "rangeType", targetEntity = PieceRange.class)
	private List<PieceRange> pieceRanges;

	public RangeType() {
	}

	public Long getIdRangeType() {
		return idRangeType;
	}

	public void setIdRangeType(Long idRangeType) {
		this.idRangeType = idRangeType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<PieceRange> getPieceRanges() {
		return pieceRanges;
	}

	public void setPieceRanges(List<PieceRange> pieceRanges) {
		this.pieceRanges = pieceRanges;
	}
}