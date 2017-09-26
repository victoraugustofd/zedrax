package br.com.zedrax.services.vo.support;

public class RangeVo {

	private Long idRange;
	private Integer x;
	private Integer y;
	private Boolean top;
	private Boolean bottom;
	private Boolean left;
	private Boolean right;
	private Boolean topRight;
	private Boolean topLeft;
	private Boolean bottomRight;
	private Boolean bottomLeft;
	private Boolean isActionInL;

	public Long getIdRange() {
		return idRange;
	}

	public void setIdRange(Long idRange) {
		this.idRange = idRange;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Boolean getTop() {
		return top;
	}

	public void setTop(Boolean top) {
		this.top = top;
	}

	public Boolean getBottom() {
		return bottom;
	}

	public void setBottom(Boolean bottom) {
		this.bottom = bottom;
	}

	public Boolean getLeft() {
		return left;
	}

	public void setLeft(Boolean left) {
		this.left = left;
	}

	public Boolean getRight() {
		return right;
	}

	public void setRight(Boolean right) {
		this.right = right;
	}

	public Boolean getTopRight() {
		return topRight;
	}

	public void setTopRight(Boolean topRight) {
		this.topRight = topRight;
	}

	public Boolean getTopLeft() {
		return topLeft;
	}

	public void setTopLeft(Boolean topLeft) {
		this.topLeft = topLeft;
	}

	public Boolean getBottomRight() {
		return bottomRight;
	}

	public void setBottomRight(Boolean bottomRight) {
		this.bottomRight = bottomRight;
	}

	public Boolean getBottomLeft() {
		return bottomLeft;
	}

	public void setBottomLeft(Boolean bottomLeft) {
		this.bottomLeft = bottomLeft;
	}

	public Boolean getIsActionInL() {
		return isActionInL;
	}

	public void setIsActionInL(Boolean isActionInL) {
		this.isActionInL = isActionInL;
	}
}