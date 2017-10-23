package br.com.zedrax.services.model.piece;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import br.com.zedrax.services.model.support.Action;

/**
 * The persistent class for the "piece" database table.
 * 
 */
@Entity
@Table(name = "piece")
public class Piece implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_piece", nullable = false, insertable = false, updatable = false)
	private Long idPiece;

	@Column(name = "name", nullable = false)
	@Length(max = 45)
	private String name;

	@Column(name = "max_hp", nullable = false, precision = 10, scale = 2)
	private Double maxHp;

	@Column(name = "atk", nullable = false, precision = 10, scale = 2)
	private Double atk;

	@Column(name = "def", nullable = false, precision = 10, scale = 2)
	private Double def;

	@Column(name = "xp_to_next_level", nullable = false, precision = 10, scale = 2)
	private Double xpToNextLevel;

	@ManyToOne(targetEntity = PieceType.class)
	@JoinColumn(name = "id_piece-type", nullable = false, foreignKey = @ForeignKey(name = "fk_piece__piece-type"))
	private PieceType pieceType;

	@ManyToOne(targetEntity = Action.class)
	@JoinColumn(name = "id_action_move", nullable = false, foreignKey = @ForeignKey(name = "fk_piece__action__move"))
	private Action move;

	@ManyToOne(targetEntity = Action.class)
	@JoinColumn(name = "id_action_atk", nullable = false, foreignKey = @ForeignKey(name = "fk_piece__action_attack"))
	private Action attack;

	public Piece() {
	}

	public Long getIdPiece() {
		return idPiece;
	}

	public void setIdPiece(Long idPiece) {
		this.idPiece = idPiece;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(Double maxHp) {
		this.maxHp = maxHp;
	}

	public Double getAtk() {
		return atk;
	}

	public void setAtk(Double atk) {
		this.atk = atk;
	}

	public Double getDef() {
		return def;
	}

	public void setDef(Double def) {
		this.def = def;
	}

	public Double getXpToNextLevel() {
		return xpToNextLevel;
	}

	public void setXpToNextLevel(Double xpToNextLevel) {
		this.xpToNextLevel = xpToNextLevel;
	}

	public PieceType getPieceType() {
		return pieceType;
	}

	public void setPieceType(PieceType pieceType) {
		this.pieceType = pieceType;
	}

	public Action getMove() {
		return move;
	}

	public void setMove(Action move) {
		this.move = move;
	}

	public Action getAttack() {
		return attack;
	}

	public void setAttack(Action attack) {
		this.attack = attack;
	}
}