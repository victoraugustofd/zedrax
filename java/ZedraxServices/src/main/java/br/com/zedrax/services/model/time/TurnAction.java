package br.com.zedrax.services.model.time;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.zedrax.services.model.piece.PieceSkill;
import br.com.zedrax.services.model.support.ActionType;
import br.com.zedrax.services.model.support.AffectedPieces;

/**
 * The persistent class for the "turn_action" database table.
 * 
 */
@Entity
@Table( name = "\"turn_action\"" )
public class TurnAction implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "\"id_turn_action\"",
			 nullable = false,
			 insertable = false,
			 updatable = false )
	private Long idTurnAction;
	
	@Column( name = "\"action_number\"", nullable = false )
	private Integer actionNumber;
	
	@ManyToOne( targetEntity = Turn.class )
	@JoinColumn( name = "\"id_turn\"", nullable = false )
	private Turn turn;
	
	@ManyToOne( targetEntity = ActionType.class )
	@JoinColumn( name = "\"id_action_type\"", nullable = false )
	private ActionType actionType;
	
	@ManyToOne( targetEntity = PieceSkill.class )
	@JoinColumn( name = "\"id_piece_skill\"", nullable = false )
	private PieceSkill pieceSkill;
	
	@OneToMany( mappedBy = "turnAction", targetEntity = AffectedPieces.class )
	private List< AffectedPieces > affectedPieces;
	
	public TurnAction() {}
	
	public Long getIdTurnAction()
	{
		return idTurnAction;
	}
	
	public void setIdTurnAction( Long idTurnAction )
	{
		this.idTurnAction = idTurnAction;
	}
	
	public Integer getActionNumber()
	{
		return actionNumber;
	}
	
	public void setActionNumber( Integer actionNumber )
	{
		this.actionNumber = actionNumber;
	}
	
	public Turn getTurn()
	{
		return turn;
	}
	
	public void setTurn( Turn turn )
	{
		this.turn = turn;
	}
	
	public List< AffectedPieces > getAffectedPieces()
	{
		return affectedPieces;
	}
	
	public void setAffectedPieces( List< AffectedPieces > affectedPieces )
	{
		this.affectedPieces = affectedPieces;
	}
	
	public ActionType getActionType()
	{
		return actionType;
	}
	
	public void setActionType( ActionType actionType )
	{
		this.actionType = actionType;
	}
	
	public PieceSkill getPieceSkill()
	{
		return pieceSkill;
	}
	
	public void setPieceSkill( PieceSkill pieceSkill )
	{
		this.pieceSkill = pieceSkill;
	}
}