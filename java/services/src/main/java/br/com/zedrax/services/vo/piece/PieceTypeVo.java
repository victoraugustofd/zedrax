package br.com.zedrax.services.vo.piece;

public class PieceTypeVo {

	private Long idPieceType;
	private String type;
	private PieceClassVo pieceClass;

	public Long getIdPieceType() {
		return idPieceType;
	}

	public void setIdPieceType(Long idPieceType) {
		this.idPieceType = idPieceType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public PieceClassVo getPieceClass() {
		return pieceClass;
	}

	public void setPieceClass(PieceClassVo pieceClass) {
		this.pieceClass = pieceClass;
	}
}