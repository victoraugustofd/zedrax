package br.com.zedrax.services.service.impl.piece;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import br.com.zedrax.services.model.piece.PieceType;
import br.com.zedrax.services.repository.piece.PieceTypeRepository;
import br.com.zedrax.services.service.intf.piece.PieceTypeService;

@Service( "pieceTypeService" )
public class PieceTypeServiceImpl implements PieceTypeService
{
	@Autowired
	private PieceTypeRepository repository;

	@Override
	public List< PieceType > retrievePieceTypeList()
	{
		Iterable< PieceType > list = repository.findAll();
		
		return Lists.newArrayList( list );
	}
}