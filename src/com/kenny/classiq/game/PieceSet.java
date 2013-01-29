package com.kenny.classiq.game;

import com.kenny.classiq.pieces.Piece;

/**
 * The <code>PieceSet</code> class represents the piece set of the
 * game, having all the pieces required to successfully complete a
 * normal chess game (the normal variant).
 * <p>
 * For the order of pieces in the piece set, please see {@link #piece}
 * @author Kenshin Himura (Sudarsan Balaji)
 */
public class PieceSet
{
	/**
	 * Holds the pieces of the game in the following order:
	 * <ol>
	 * <li>00-47: WHITE pieces
	 * <ol>
	 * <li>00-07: Pawn
	 * <li>08-17: Knight
	 * <li>18-27: Bishop 
	 * <li>28-37: Rook
	 * <li>38-46: Queen
	 * <li>47-47: King
	 * </ol>
	 * <li>48-95: BLACK pieces
	 * <ol>
	 * <li>48-55: Pawn
	 * <li>56-65: Knight
	 * <li>66-75: Bishop 
	 * <li>76-85: Rook
	 * <li>86-94: Queen
	 * <li>95-95: King
	 * </ol>
	 * </ol>
	 * <p>
	 * Extra pieces have been provided so as to accomodate for
	 * promotion of a pawn to any other piece.
	 */
	private Piece[] piece;
	/**
	 * Generic getter method to access a piece. Since the piece[] is a
	 * private data member, it should be accessed using a public getter
	 * method. Since getting all pieces is going to be useless, we can
	 * get specific pieces from the <code>PieceSet</code> using an index.
	 * @param index The index of the <code>Piece</code> queried.
	 * @return The <code>Piece</code> at the specified index.
	 */
	public Piece getPiece(int index)
	{
		Piece returnPiece=piece[index];
		piece[index]=null;
		return returnPiece;
	}
	/**
	 * Places the piece in the piece table, calculating a specific
	 * index (location) for the placement.
	 * @param piece The <code>Piece</code> to be placed in the
	 * <code>PieceSet</code>
	 */
	public void setPiece(Piece piece)
	{
		int index1=0,index2=8;
		if(piece.getShortAlgebraicNotation()=="N")
		{
			index1=8;
			index2=17;
		}
		if(piece.getShortAlgebraicNotation()=="B")
		{
			index1=18;
			index2=27;
		}
		if(piece.getShortAlgebraicNotation()=="R")
		{
			index1=28;
			index2=37;
		}
		if(piece.getShortAlgebraicNotation()=="Q")
		{
			index1=38;
			index2=46;
		}
		if(piece.getShortAlgebraicNotation()=="K")
		{
			index1=47;
			index2=47;
		}
		if(!piece.isWhite())
		{
			index1+=48;
			index2+=48;
		}
		for(;index1<=index2;index1++)
			if(this.piece[index1]==null)
			{
				this.piece[index1] = piece;
				break;
			}
	}
}