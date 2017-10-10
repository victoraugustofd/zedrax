package br.com.zedrax.services.model.support;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;

/**
 * The persistent class for the "action_type" database table.
 * 
 */
@Entity
@Table(name = "action_type", uniqueConstraints = @UniqueConstraint(name = "uk_action_type__type", columnNames = "type"))
public class ActionType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_action_type", nullable = false, insertable = false, updatable = false)
	private Long idActionType;

	@Column(name = "type", nullable = false)
	@Length(max = 100)
	private String type;

	public ActionType() {
	}
	
	public ActionType(String type) {
		setType(type);
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getIdActionType() {
		return this.idActionType;
	}

	public void setIdActionType(Long idActionType) {
		this.idActionType = idActionType;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean equals = false;

		if (obj != this) {
			if (obj instanceof ActionType) {
				ActionType actioType = (ActionType) obj;

				if (Objects.equals(type, actioType.getType()))
					equals = true;
			}
		}

		return equals;
	}
}