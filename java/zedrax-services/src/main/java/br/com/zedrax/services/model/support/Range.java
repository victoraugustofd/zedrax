package br.com.zedrax.services.model.support;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the "action_type" database table.
 * 
 */
@Entity
@Table(name = "\"range\"")
public class Range implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_range", nullable = false, insertable = false, updatable = false)
	private Long idRange;

	@Column(name = "x", nullable = false)
	private Integer x;

	@Column(name = "y", nullable = false)
	private Integer y;

	@Column(name = "top", nullable = false, columnDefinition = "BOOLEAN")
	private Boolean top;

	@Column(name = "bottom", nullable = false, columnDefinition = "BOOLEAN")
	private Boolean bottom;

	@Column(name = "\"left\"", nullable = false, columnDefinition = "BOOLEAN")
	private Boolean left;

	@Column(name = "\"right\"", nullable = false, columnDefinition = "BOOLEAN")
	private Boolean right;

	@Column(name = "top_right", nullable = false, columnDefinition = "BOOLEAN")
	private Boolean topRight;

	@Column(name = "top_left", nullable = false, columnDefinition = "BOOLEAN")
	private Boolean topLeft;

	@Column(name = "bottom_right", nullable = false, columnDefinition = "BOOLEAN")
	private Boolean bottomRight;

	@Column(name = "bottom_left", nullable = false, columnDefinition = "BOOLEAN")
	private Boolean bottomLeft;

	@Column(name = "is_action_in_l", nullable = false, columnDefinition = "BOOLEAN")
	private Boolean isActionInL;

	public Range() {
	}

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