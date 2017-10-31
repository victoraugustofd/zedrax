package br.com.zedrax.services.model.ai;

public class AiActionUnreal {

    private Integer idAction;
    private Integer xPositionFrom;
    private Integer yPositionFrom;
    private Integer xPositionTo;
    private Integer yPositionTo;

    public AiActionUnreal(Integer idAction, Integer xPositionFrom, Integer yPositionFrom, Integer xPositionTo,
            Integer yPositionTo) {

        setIdAction(idAction);
        setxPositionFrom(xPositionFrom);
        setyPositionFrom(yPositionFrom);
        setxPositionTo(xPositionTo);
        setyPositionTo(yPositionTo);
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
}