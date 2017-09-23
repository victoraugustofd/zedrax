package br.com.zedrax.zedraxview.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

public class BoardConfiguration extends JFrame implements ActionListener
{
	private JCheckBox chkUseDefault;
	private JPanel panelBoardConfig;
	private JPanel panelSquareDimension;
	private JLabel lblNumberOfRows;
	private JLabel lblNumberOfColumns;
	private JLabel lblSquareWidth;
	private JLabel lblSquareHeight;
	private JFormattedTextField txtNumberOfRows;
	private JFormattedTextField txtNumberOfColumns;
	private JFormattedTextField txtSquareWidth;
	private JFormattedTextField txtSquareHeight;
	private JButton btnCreateBoard;
	
	public BoardConfiguration()
	{
		super( "Board Configuration" );
		
		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		numberFormat.setMinimumIntegerDigits( 1 );
		numberFormat.setMaximumIntegerDigits( 2 );
		numberFormat.setMaximumFractionDigits( 0 );
		
		chkUseDefault = new JCheckBox( "Use default configuration ( Board: 10 x 10 / Size: 70px )" );
		panelBoardConfig = new JPanel( new GridLayout( 2, 2, 10, 10 ) );
		panelSquareDimension = new JPanel( new GridLayout( 2, 2, 10, 10 ) );
		lblNumberOfRows = new JLabel( "Number of Rows:" );
		lblNumberOfColumns = new JLabel( "Number of Columns:" );
		lblSquareWidth = new JLabel( "Width:" );
		lblSquareHeight = new JLabel( "Height:" );
		txtNumberOfRows = new JFormattedTextField( numberFormat );
		txtNumberOfColumns = new JFormattedTextField( numberFormat );
		txtSquareWidth = new JFormattedTextField( numberFormat );
		txtSquareHeight = new JFormattedTextField( numberFormat );
		btnCreateBoard = new JButton( "Create" );
		
		getContentPane().setBackground( Color.WHITE );
		panelBoardConfig.setBackground( Color.WHITE );
		panelSquareDimension.setBackground( Color.WHITE );
		chkUseDefault.setBackground( Color.WHITE );
		txtNumberOfRows.setBackground( Color.WHITE );
		txtNumberOfColumns.setBackground( Color.WHITE );
		txtSquareWidth.setBackground( Color.WHITE );
		txtSquareHeight.setBackground( Color.WHITE );
		
		panelBoardConfig.setBorder( BorderFactory.createTitledBorder( "Board Configuration" ) );
		panelSquareDimension.setBorder( BorderFactory.createTitledBorder( "Square Dimensions" ) );
		
		panelBoardConfig.add( lblNumberOfRows );
		panelBoardConfig.add( txtNumberOfRows );
		panelBoardConfig.add( lblNumberOfColumns );
		panelBoardConfig.add( txtNumberOfColumns );
		panelSquareDimension.add( lblSquareWidth );
		panelSquareDimension.add( txtSquareWidth );
		panelSquareDimension.add( lblSquareHeight );
		panelSquareDimension.add( txtSquareHeight );
		
		add( panelBoardConfig );
		add( panelSquareDimension );
		add( chkUseDefault );
		add( btnCreateBoard );
		
		panelBoardConfig.setBounds( 30, 30, 250, 100 );
		
		panelSquareDimension.setBounds( panelBoardConfig.getX() + panelBoardConfig.getWidth() + 10,
										panelBoardConfig.getY(),
										panelBoardConfig.getWidth(),
										panelBoardConfig.getHeight() );
		
		chkUseDefault.setBounds( panelBoardConfig.getX(),
								 panelBoardConfig.getY() + panelBoardConfig.getHeight() + 10,
								 350,
								 20 );
		
		btnCreateBoard.setBounds( panelSquareDimension.getX() + panelSquareDimension.getWidth() - 80,
								  panelSquareDimension.getY() + panelSquareDimension.getHeight() + 10,
								  80,
								  30 );
		
		chkUseDefault.addActionListener( this );
		btnCreateBoard.addActionListener( this );
		
		getContentPane().setBackground( Color.WHITE );
		setSize( 580, 210 );
		setLayout( null );
		setLocationRelativeTo( null );
		setResizable( false );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setVisible( true );
	}
	
	@Override
	public void actionPerformed( ActionEvent event )
	{
		if( event.getSource().equals( chkUseDefault ) )
		{
			txtNumberOfRows.setEditable( !txtNumberOfRows.isEditable() );
			txtNumberOfColumns.setEditable( !txtNumberOfColumns.isEditable() );
			txtSquareWidth.setEditable( !txtSquareWidth.isEditable() );
			txtSquareHeight.setEditable( !txtSquareHeight.isEditable() );
			txtNumberOfRows.setText( "10" );
			txtNumberOfColumns.setText( "10" );
			txtSquareWidth.setText( "70" );
			txtSquareHeight.setText( "70" );
		}
		else if( event.getSource().equals( btnCreateBoard ) )
		{
			int numberOfRows = Integer.parseInt( txtNumberOfRows.getText() );
			int numberOfColumns = Integer.parseInt( txtNumberOfColumns.getText() );
			Dimension squareDimension = new Dimension( Integer.parseInt( txtSquareWidth.getText() ), Integer.parseInt( txtSquareHeight.getText() ) );
			
			Board board = new Board( numberOfRows, numberOfColumns, squareDimension );
			PiecesData pieces = new PiecesData();
			
			board.setBackground( Color.WHITE );
			
			JFrame frame = new JFrame( "[ Zedrax ]" );
			frame.getContentPane().setBackground( Color.WHITE );
			frame.add( board );
//			frame.add( pieces );
			frame.setVisible( true );
			frame.setSize( 1500, 900 );
			frame.setLocationRelativeTo( null );
			frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		}
	}
}