package br.com.zedrax.services.model.ai;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class AiAction {

    private Integer pieceIndex;
    private Integer idAction;
    private Integer xPositionFrom;
    private Integer yPositionFrom;
    private Integer xPositionTo;
    private Integer yPositionTo;
    private Integer weight;
    private Integer manaCost;
    private Boolean blocked;
    private List<Integer> piecesBlocking;
    private AiData affectedPiece;

    public Integer getPieceIndex() {
        return pieceIndex;
    }

    public void setPieceIndex(Integer pieceIndex) {
        this.pieceIndex = pieceIndex;
    }

    public Integer getIdAction() {
        return idAction;
    }

    public void setIdAction(Integer idAction) {
        this.idAction = idAction;
    }

    public Integer getxPositionFrom() {
        return xPositionFrom;
    }

    public void setxPositionFrom(Integer xPositionFrom) {
        this.xPositionFrom = xPositionFrom;
    }

    public Integer getyPositionFrom() {
        return yPositionFrom;
    }

    public void setyPositionFrom(Integer yPositionFrom) {
        this.yPositionFrom = yPositionFrom;
    }

    public Integer getxPositionTo() {
        return xPositionTo;
    }

    public void setxPositionTo(Integer xPositionTo) {
        this.xPositionTo = xPositionTo;
    }

    public Integer getyPositionTo() {
        return yPositionTo;
    }

    public void setyPositionTo(Integer yPositionTo) {
        this.yPositionTo = yPositionTo;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getManaCost() {
        return manaCost;
    }

    public void setManaCost(Integer manaCost) {
        this.manaCost = manaCost;
    }

    public Boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public List<Integer> getPiecesBlocking() {
        return piecesBlocking;
    }

    public void setPiecesBlocking(List<Integer> piecesBlocking) {
        this.piecesBlocking = piecesBlocking;
    }

    public AiData getAffectedPiece() {
        return affectedPiece;
    }

    public void setAffectedPiece(AiData affectedPiece) {
        this.affectedPiece = affectedPiece;
    }

    @Override
    public String toString() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {

            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {

            e.printStackTrace();
        }

        return super.toString();
    }
}