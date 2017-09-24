package br.com.zedrax.services.controller.piece;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.zedrax.services.model.piece.PieceType;
import br.com.zedrax.services.service.interfaces.piece.IPieceTypeService;

@RestController("pieceTypeController")
public class PieceTypeController {
	@Autowired
	private IPieceTypeService service;

	@RequestMapping(value = "retrievePieceTypeList", method = RequestMethod.GET)
	public ResponseEntity<List<PieceType>> retrievePieceTypeListRest() {
		List<PieceType> pieceTypeList = service.retrievePieceTypeList();

		return new ResponseEntity<List<PieceType>>(pieceTypeList, HttpStatus.OK);
	}
}