package br.com.zedrax.zedraxservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.zedrax.zedraxservices.model.piece.PieceType;
import br.com.zedrax.zedraxservices.repository.PieceTypeRepository;

@Controller
public class PieceTypeController
{
	@Autowired
	private PieceTypeRepository repository;
	
	@RequestMapping( "retrievePieceTypeList" )
	public String retrievePieceTypeList( Model model )
	{
		Iterable< PieceType > pieceTypeList = repository.findAll();
		
		model.addAttribute( "pieceTypeList", pieceTypeList );
		
		return "retrievePieceTypeList";
	}
}