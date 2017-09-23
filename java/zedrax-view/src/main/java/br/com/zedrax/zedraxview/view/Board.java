package br.com.zedrax.zedraxview.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener
{
	private int numberOfRows;
	private int numberOfColumns;
	private Dimension squareDimension;
	
	public Board( int numberOfRows, int numberOfColumns, Dimension squareDimension )
	{
		setNumberOfRows( numberOfRows );
		setNumberOfColumns( numberOfColumns );
		setSquareDimension( squareDimension );
	}

	public void paintComponent( Graphics graphics )
	{
		super.paintComponent( graphics );
		
		Graphics2D graphics2D = ( Graphics2D ) graphics;
		Rectangle2D externalBoard;
		Rectangle2D square;
		Color[] colors = { Color.BLACK, Color.WHITE };
	    List< String > alphabet = IntStream.rangeClosed( 'A', 'Z' ).mapToObj( c -> "" + ( char ) c ).collect( Collectors.toList() );
	    
		int numberOfRowsAux = numberOfRows;
		int initialX = 10;
		int initialY = 50;
		boolean changeColor = false;
		String[][] positionNames = new String[ numberOfRows ][ numberOfColumns ];
		
		// Draw a border on the external board
		graphics2D.setColor( Color.BLACK );
		graphics2D.drawRect( ( int ) initialX - 1,
							 ( int ) initialY - 1,
							 ( int ) ( ( numberOfColumns + 1 ) * squareDimension.getWidth() + 1 ),
							 ( int ) ( ( numberOfRows + 1 ) * squareDimension.getHeight() ) + 1 );
		
		// Draw external board
		externalBoard = new Rectangle2D.Double( initialX, initialY, ( numberOfColumns + 1 ) * squareDimension.getWidth(), ( numberOfRows + 1 ) * squareDimension.getHeight() );
		graphics2D.setColor( Color.WHITE );
		graphics2D.fill( externalBoard );
		
		// Draw a border for the internal board 
		graphics2D.setColor( Color.BLACK );
		graphics2D.drawRect( ( int ) ( initialX + squareDimension.getWidth() - 1 ),
						     ( int ) initialY - 1,
						     ( int ) ( ( numberOfColumns ) * squareDimension.getWidth() + 1 ),
						     ( int ) ( ( numberOfRows ) * squareDimension.getHeight() + 1 ) );
		
		// Draw column names
		for( int i = 0; i < numberOfColumns; i++ )
		{
			graphics2D.drawString( alphabet.get( i ),
								   ( int ) ( initialX + ( squareDimension.getWidth() * ( i + 2 ) ) - squareDimension.getWidth() / 2 ),
								   initialY - 15 );
		}
		
		// Draw row names
		for( int i = 0; i < numberOfRows; i++ )
		{
			graphics2D.drawString( String.valueOf( numberOfRowsAux-- ),
								   ( int ) ( initialX + ( ( numberOfColumns + 1 ) * squareDimension.getWidth() ) + 15 ),
								   ( int ) ( initialY + ( squareDimension.getHeight() * ( i + 1 ) ) - squareDimension.getHeight() / 2 ) + 5 );
		}
		
		// Draw board itself
		for( int i = 0; i < numberOfRows; i++ )
		{
			for( int j = 1; j < numberOfColumns + 1; j++ )
			{
				square = new Rectangle2D.Double( initialX + ( squareDimension.getWidth() * j ), 
											     initialY + ( squareDimension.getHeight() * i ), 
											     squareDimension.getWidth(),
											     squareDimension.getHeight() );
				
				graphics2D.setColor( changeColor ? colors[ 0 ] : colors[ 1 ] );
				graphics2D.fill( square );
				changeColor = !changeColor;
				
				positionNames[ i ][ j - 1 ] = alphabet.get( j - 1 ) + ( numberOfRows - i );
			}
			
			if( numberOfColumns % 2 == 0 )
				changeColor = !changeColor;
		}
		
		System.out.println(  );
	}
	
	@Override
	public void actionPerformed( ActionEvent arg0 )
	{
		
	}

	public int getNumberOfRows()
	{
		return numberOfRows;
	}

	public void setNumberOfRows( int numberOfRows )
	{
		this.numberOfRows = numberOfRows;
	}

	public int getNumberOfColumns()
	{
		return numberOfColumns;
	}

	public void setNumberOfColumns( int numberOfColumns )
	{
		this.numberOfColumns = numberOfColumns;
	}

	public Dimension getSquareDimension()
	{
		return squareDimension;
	}

	public void setSquareDimension( Dimension squareDimension )
	{
		this.squareDimension = squareDimension;
	}
}