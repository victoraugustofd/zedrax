package br.com.zedrax.services.model.piece;

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

/**
 * The persistent class for the "piece_level" database table.
 * 
 */
@Entity
@Table(name = "\"piece_level\"")
public class PieceLevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"id_piece_level\"", nullable = false, insertable = false, updatable = false)
	private Long idPieceLevel;

	@Column(name = "\"atk_cost\"", nullable = false)
	private Integer atkCost;

	@Column(name = "\"basic_atk\"", nullable = false)
	@Digits(integer = 10, fraction = 2)
	private Integer basicAtk;

	@Column(name = "\"basic_def\"", nullable = false)
	@Digits(integer = 10, fraction = 2)
	private BigDecimal basicDef;

	@Column(name = "\"hp\"", nullable = false)
	@Digits(integer = 10, fraction = 2)
	private BigDecimal hp;

	@Column(name = "\"level\"", nullable = false)
	private Integer level;

	@Column(name = "\"mov_cost\"", nullable = false)
	private Integer movCost;

	@Column(name = "\"skill_def\"", nullable = false)
	@Digits(integer = 10, fraction = 2)
	private BigDecimal skillDef;

	@Column(name = "\"xp_for_next_level\"", nullable = false)
	@Digits(integer = 10, fraction = 2)
	private BigDecimal xpForNextLevel;

	@ManyToOne(targetEntity = Piece.class)
	@JoinColumn(name = "\"id_piece\"", nullable = false)
	private Piece piece;

	public PieceLevel() {
	}

	public Integer getAtkCost() {
		return this.atkCost;
	}

	public void setAtkCost(Integer atkCost) {
		this.atkCost = atkCost;
	}

	public Integer getBasicAtk() {
		return this.basicAtk;
	}

	public void setBasicAtk(Integer basicAtk) {
		this.basicAtk = basicAtk;
	}

	public BigDecimal getBasicDef() {
		return this.basicDef;
	}

	public void setBasicDef(BigDecimal basicDef) {
		this.basicDef = basicDef;
	}

	public BigDecimal getHp() {
		return this.hp;
	}

	public void setHp(BigDecimal hp) {
		this.hp = hp;
	}

	public Long getIdPieceLevel() {
		return this.idPieceLevel;
	}

	public void setIdPieceLevel(Long idPieceLevel) {
		this.idPieceLevel = idPieceLevel;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getMovCost() {
		return this.movCost;
	}

	public void setMovCost(Integer movCost) {
		this.movCost = movCost;
	}

	public BigDecimal getSkillDef() {
		return this.skillDef;
	}

	public void setSkillDef(BigDecimal skillDef) {
		this.skillDef = skillDef;
	}

	public BigDecimal getXpForNextLevel() {
		return this.xpForNextLevel;
	}

	public void setXpForNextLevel(BigDecimal xpForNextLevel) {
		this.xpForNextLevel = xpForNextLevel;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
}