package br.com.zedrax.services.model.ai;

public class AiAction {

    private Integer idAction;
    private Integer xPositionFrom;
    private Integer yPositionFrom;
    private Integer xPositionTo;
    private Integer yPositionTo;
    private Integer weight;
    private Integer manaCost;

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
}