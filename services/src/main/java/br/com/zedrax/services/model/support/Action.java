package br.com.zedrax.services.model.support;

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

/**
 * The persistent class for the "action_type" database table.
 * 
 */
@Entity
@Table(name = "action")
public class Action implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_action", nullable = false, insertable = false, updatable = false)
    private Long idAction;

    @Column(name = "mana_cost", nullable = false)
    private Integer manaCost;

    @ManyToOne(targetEntity = ActionType.class)
    @JoinColumn(name = "id_action_type", nullable = false, foreignKey = @ForeignKey(name = "fk_action__action_type"))
    private ActionType actionType;

    @ManyToOne(targetEntity = Range.class)
    @JoinColumn(name = "id_range", nullable = false, foreignKey = @ForeignKey(name = "fk_action__range"))
    private Range range;

    public Action() {
    }

    public Long getIdAction() {
        return idAction;
    }

    public void setIdAction(Long idAction) {
        this.idAction = idAction;
    }

    public Integer getManaCost() {
        return manaCost;
    }

    public void setManaCost(Integer manaCost) {
        this.manaCost = manaCost;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }
}