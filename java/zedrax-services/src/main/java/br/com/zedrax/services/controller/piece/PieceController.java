package br.com.zedrax.services.controller.piece;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zedrax.services.model.piece.Piece;
import br.com.zedrax.services.service.interfaces.piece.IPieceService;
import br.com.zedrax.services.vo.piece.PieceVo;
import br.com.zedrax.services.vo.unreal.DataVo;

@RestController("pieceController")
@RequestMapping(value = "/retrieve-pieces", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PieceController {
	@Autowired
	private IPieceService service;

	@Autowired
	private ModelMapper modelMapper;
	
	@RequestMapping(value = "/initial-data", method = RequestMethod.GET)
	public @ResponseBody List<PieceVo> retrievePiecesInitialData() {
		return retrievePiecesInitialDataGeneric();
	}
	
	@RequestMapping(value = "/initial-data-unreal", method = RequestMethod.GET)
	public @ResponseBody DataVo<PieceVo> retrievePiecesInitialDataUnreal() {
		DataVo<PieceVo> data = new DataVo<>();
		data.setData(retrievePiecesInitialDataGeneric());
		
		return data;
	}
	
	public List<PieceVo> retrievePiecesInitialDataGeneric() {
		return service.retrieveInitialData()
				.stream()
				.map(piece -> convertEntityToVo(piece))
				.collect(Collectors.toList());
	}
	
	private PieceVo convertEntityToVo(Piece entity) {
		return modelMapper.map(entity, PieceVo.class);
	}
}