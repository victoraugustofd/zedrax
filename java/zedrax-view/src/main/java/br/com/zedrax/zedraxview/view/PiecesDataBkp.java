package br.com.zedrax.zedraxview.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.MaskFormatter;

import br.com.usjt.cco4anmca.tcc.zedraxview.utils.ProjectUtils;

public class PiecesDataBkp extends JPanel implements ActionListener
{
	private JScrollPane scrollExternal;
	private JScrollPane scrollBlack;
	private JScrollPane scrollWhite;
	private JPanel panelBlackPieces;
	private JPanel panelWhitePieces;
	private JLabel lblBlack;
	private JLabel lblWhite;
	private JLabel lblHP;
	private JLabel lblMP;
	private JLabel lblAttack;
	private JLabel lblPhysicalDefense;
	private JLabel lblMagicalDefense;
	private JLabel lblSkillUltimate;
	private BufferedImage imgKing;
	private BufferedImage imgQueen;
	private BufferedImage imgRook;
	private BufferedImage imgBishop;
	private BufferedImage imgKnight;
	private BufferedImage imgWarriorPawn;
	private BufferedImage imgTankPawn;
	private BufferedImage imgArcherPawn;
	private BufferedImage imgNinjaPawn;
	private JButton btnMinus;
	private JFormattedTextField txtHP;
	private JFormattedTextField txtMP;
	private JFormattedTextField txtAttack;
	private JFormattedTextField txtPhysicalDefense;
	private JFormattedTextField txtMagicalDefense;
	private JFormattedTextField txtSkillUltimate;
	
	public PiecesDataBkp()
	{
		scrollExternal = new JScrollPane();
		scrollBlack = new JScrollPane();
		scrollWhite = new JScrollPane();
		panelBlackPieces = new JPanel();
		panelWhitePieces = new JPanel();
		lblBlack = new JLabel( "Black" );
		lblWhite = new JLabel( "White" );
		lblHP = new JLabel( "HP:" );
		lblMP = new JLabel( "MP:" );
		lblAttack = new JLabel( "ATK:" );
		lblPhysicalDefense = new JLabel( "DEF F:" );
		lblMagicalDefense = new JLabel( "DEF M:" );
		lblSkillUltimate = new JLabel( "Ultimate:" );
		btnMinus = new JButton( "-" );
		txtHP = new JFormattedTextField( createFormatter( "#####" ) );
		txtMP = new JFormattedTextField( createFormatter( "#####" ) );
		txtAttack = new JFormattedTextField( createFormatter( "#####" ) );
		txtPhysicalDefense = new JFormattedTextField( createFormatter( "#####" ) );
		txtMagicalDefense = new JFormattedTextField( createFormatter( "#####" ) );
		txtSkillUltimate = new JFormattedTextField( createFormatter( "#####" ) );
		loadImages();
	}
	
	@Override
	protected void paintComponent( Graphics graphics )
	{
		super.paintComponent( graphics );
		
		graphics.drawImage( imgArcherPawn, 700, 10, null );
	}
	
	@Override
	public void actionPerformed( ActionEvent arg0 )
	{
		
	}
	
	private void loadImages()
	{
		try
		{
			imgKing = ImageIO.read( new File( ProjectUtils.RESOURCES_PATH + "king.png" ) );
			imgQueen = ImageIO.read( new File( ProjectUtils.RESOURCES_PATH + "queen.png" ) );
			imgRook = ImageIO.read( new File( ProjectUtils.RESOURCES_PATH + "rook.png" ) );
			imgBishop = ImageIO.read( new File( ProjectUtils.RESOURCES_PATH + "bishop.png" ) );
			imgKnight = ImageIO.read( new File( ProjectUtils.RESOURCES_PATH + "knight.png" ) );
			imgWarriorPawn = ImageIO.read( new File( ProjectUtils.RESOURCES_PATH + "pawn_warrior.png" ) );
			imgTankPawn = ImageIO.read( new File( ProjectUtils.RESOURCES_PATH + "pawn_tank.png" ) );
			imgArcherPawn = ImageIO.read( new File( ProjectUtils.RESOURCES_PATH + "pawn_archer.png" ) );
			imgNinjaPawn = ImageIO.read( new File( ProjectUtils.RESOURCES_PATH + "pawn_ninja.png" ) );
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
	}
	
	private MaskFormatter createFormatter( String format )
	{
		MaskFormatter formatter = null;
		
		try
		{
			formatter = new MaskFormatter( format );
		}
		catch ( java.text.ParseException e )
		{
			e.printStackTrace();
		}
		
		return formatter;
	}
}