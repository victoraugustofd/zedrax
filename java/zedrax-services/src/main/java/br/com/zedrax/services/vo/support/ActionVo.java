package br.com.zedrax.services.vo.support;

public class ActionVo {

	private Long idAction;
	private Integer manaCost;
	private ActionTypeVo actionType;
	private RangeVo range;

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

	public ActionTypeVo getActionType() {
		return actionType;
	}

	public void setActionType(ActionTypeVo actionType) {
		this.actionType = actionType;
	}

	public RangeVo getRange() {
		return range;
	}

	public void setRange(RangeVo range) {
		this.range = range;
	}
}