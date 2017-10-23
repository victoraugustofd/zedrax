package br.com.zedrax.services.vo.piece;

import br.com.zedrax.services.vo.support.ActionVo;

public class PieceVo {

    private Long idPiece;
    private String name;
    private Double maxHp;
    private Double atk;
    private Double def;
    private Double xpToNextLevel;
    private PieceTypeVo pieceType;
    private ActionVo move;
    private ActionVo attack;

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

    public PieceTypeVo getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceTypeVo pieceType) {
        this.pieceType = pieceType;
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