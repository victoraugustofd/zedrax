package br.com.zedrax.services.model.ai;

import br.com.zedrax.services.vo.support.ActionVo;

public class AiData {

	private Boolean isAlly;
	private Integer pieceType;
	private Integer xPosition;
	private Integer yPosition;
	private Integer level;
	private Double hp;
	private Double hpMax;
	private Double atk;
	private Double def;
	private ActionVo move;
	private ActionVo attack;

	public Boolean isAlly() {
		return isAlly;
	}

	public void setAlly(Boolean isAlly) {
		this.isAlly = isAlly;
	}

	public Integer getPieceType() {
		return pieceType;
	}

	public void setPieceType(Integer pieceType) {
		this.pieceType = pieceType;
	}

	public Integer getxPosition() {
		return xPosition;
	}

	public void setxPosition(Integer xPosition) {
		this.xPosition = xPosition;
	}

	public Integer getyPosition() {
		return yPosition;
	}

	public void setyPosition(Integer yPosition) {
		this.yPosition = yPosition;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Double getHp() {
		return hp;
	}

	public void setHp(Double hp) {
		this.hp = hp;
	}

	public Double getHpMax() {
		return hpMax;
	}

	public void setHpMax(Double hpMax) {
		this.hpMax = hpMax;
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

	public ActionVo getMove() {
		return move;
	}

	public void setMove(ActionVo move) {
		this.move = move;
	}

	public ActionVo getAttack() {
		return attack;
	}

	public void setAttack(ActionVo attack) {
		this.attack = attack;
	}
}