package br.com.zedrax.services.loader.piece;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.zedrax.services.model.piece.PieceTypeClass;
import br.com.zedrax.services.repository.piece.PieceTypeClassRepository;

@Component
@Order( value = 1 )
public class PieceTypeClassLoader implements ApplicationRunner
{
	@Value( "${piece_type_class.pawn}" )
	private String pawn;
	
	@Value( "${piece_type_class.elite}" )
	private String elite;
	
	@SuppressWarnings( "unused" )
	private final static Logger logger = Logger.getLogger( PieceTypeClassLoader.class );
	
	@Autowired
	private PieceTypeClassRepository repository;
	
	public void run( ApplicationArguments args )
	{
		List< PieceTypeClass > listFromDb = repository.findAll();
		List< PieceTypeClass > newList = new ArrayList<>();
		
		newList.add( new PieceTypeClass( pawn ) );
		newList.add( new PieceTypeClass( elite ) );
		
		newList.removeAll( listFromDb );
		
		repository.save( newList );
	}
}