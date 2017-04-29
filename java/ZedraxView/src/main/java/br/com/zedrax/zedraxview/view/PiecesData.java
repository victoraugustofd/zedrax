package br.com.zedrax.zedraxview.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PiecesData extends JFrame implements ActionListener
{
	private DefaultTableModel dtm;
	private JTable table;
	private JScrollPane scroll;
	private JButton btnDefaultConfig;
	private List< String > tableHeader;
	private List< String > piecesNames;
	
	public PiecesData()
	{
		super( "Pieces Data" );
		
		loadTableHeader();
		loadPiecesNames();
		dtm = new DefaultTableModel( tableHeader.toArray(), piecesNames.size() );
		table = new JTable( dtm )
				{
					@Override
				    public boolean isCellEditable( int row, int column )
				    {
						if( column == 0 )
							return false;
						
						return true;
				    };
				};
		
		scroll = new JScrollPane( table );
		btnDefaultConfig = new JButton( "Merge config" );
		
		for ( int i = 0; i < piecesNames.size(); i++ )
		{
			dtm.setValueAt( piecesNames.get( i ), i, 0 );
		}
		
		add( scroll );
		add( btnDefaultConfig );
		
		scroll.setBounds( 10, 10, 800, 400 );
		btnDefaultConfig.setBounds( scroll.getX(), scroll.getY() + scroll.getHeight() + 10, 120, 30 );
		
		btnDefaultConfig.addActionListener( this );
		
		table.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
		
		getContentPane().setBackground( Color.WHITE );
		setSize( 900, 500 );
		setLayout( null );
		setLocationRelativeTo( null );
		setResizable( false );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setVisible( true );
	}
	
	@Override
	public void actionPerformed( ActionEvent event )
	{
		if( event.getSource().equals( btnDefaultConfig ) )
		{
			int aux = piecesNames.size() / 2;
			
			for( int i = 0; i < aux; i++ )
			{
				for( int j = 1; j < tableHeader.size(); j++ )
				{
					dtm.setValueAt( dtm.getValueAt( i, j ), i + aux, j );
				}
			}
			
			repaint();
		}
	}
	
	private void loadTableHeader()
	{
		tableHeader = Arrays.asList( "Piece",
									 "HP",
									 "MP",
									 "Attack",
									 "Physical Defense",
									 "Magical Defense",
									 "Skill Ultimate" );
	}
	
	private void loadPiecesNames()
	{
		piecesNames = Arrays.asList( "Black King",
									 "Black Queen",
									 "Black Bishop 1",
									 "Black Bishop 2",
									 "Black Knight 1",
									 "Black Knight 2",
									 "Black Rook 1",
									 "Black Rook 2",
									 "Black Warrior Pawn 1",
									 "Black Warrior Pawn 2",
									 "Black Tank Pawn 1",
									 "Black Tank Pawn 2",
									 "Black Archer Pawn 1",
									 "Black Archer Pawn 2",
									 "Black Ninja Pawn 1",
									 "Black Ninja Pawn 2",
									 "White King",
									 "White Queen",
									 "White Bishop 1",
									 "White Bishop 2",
									 "White Knight 1",
									 "White Knight 2",
									 "White Rook 1",
									 "White Rook 2",
									 "White Warrior Pawn 1",
									 "White Warrior Pawn 2",
									 "White Tank Pawn 1",
									 "White Tank Pawn 2",
									 "White Archer Pawn 1",
									 "White Archer Pawn 2",
									 "White Ninja Pawn 1",
									 "White Ninja Pawn 2" );
	}
}