/*
 * This file is part of "Kenny ClassIQ", (c) Kenshin Himura, 2013.
 * 
 * "Kenny ClassIQ" is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * "Kenny ClassIQ" is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with "Kenny ClassIQ".  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package com.kenny.classiq.pieces;

import java.util.ArrayList;

import com.kenny.classiq.board.Square;
import com.kenny.classiq.definitions.PieceValues;
import com.kenny.classiq.game.Move;

public class Pawn extends Piece
{
	public Pawn()
	{
		pieceValue=PieceValues.pawnValue;
		shortAlgebraicNotation="P";
	}
	public ArrayList<Move> getMoves()
	{
		ArrayList<Move> returnList=new ArrayList<Move>();
		ArrayList<Square> toSquares=new ArrayList<Square>();
		if(square!=null)
		{
			if(white)
			{
				addCaptureSquare(square.getTopRightSquare(),toSquares);
				addCaptureSquare(square.getTopLeftSquare(),toSquares);
				addMoveToSquare(square.getTopSquare(),toSquares);
				if(square.getRankIndex()==1)
					if(square.getTopSquare().getPiece()==null)
						if(square.getTopSquare().getTopSquare().
							getPiece()==null)
							toSquares.add(square.getTopSquare().
							getTopSquare());
				if(square.getRankIndex()==4)
				{
					Square epSquare=square.getBoard().getGame().getEnPassantSquare();
					if(epSquare!=null)
						if(epSquare.getRankIndex()==5)
							if((epSquare.getFileIndex()-square.getFileIndex()==1)||
								(epSquare.getFileIndex()-square.getFileIndex()==-1))
								addMoveToSquare(epSquare,toSquares);
				}
			}
			else
			{
				addCaptureSquare(square.getBottomRightSquare(),toSquares);
				addCaptureSquare(square.getBottomLeftSquare(),toSquares);
				addMoveToSquare(square.getBottomSquare(),toSquares);
				if(square.getRankIndex()==6)
					if(square.getBottomSquare().getPiece()==null)
						if(square.getBottomSquare().getBottomSquare().
							getPiece()==null)
							toSquares.add(square.getBottomSquare().
							getBottomSquare());
				if(square.getRankIndex()==3)
				{
					Square epSquare=square.getBoard().getGame().getEnPassantSquare();
					if(epSquare!=null)
						if(epSquare.getRankIndex()==2)
							if((epSquare.getFileIndex()-square.getFileIndex()==1)||
								(epSquare.getFileIndex()-square.getFileIndex()==-1))
								addMoveToSquare(epSquare,toSquares);
				}
			}
			if(!toSquares.isEmpty())
				for(byte i=0;i<toSquares.size();i++)
				{
					Move tempMove=new Move(square,toSquares.get(i));
					returnList.add(tempMove);
					if(((toSquares.get(i).getRankIndex()==0)&&(!white))||
						((toSquares.get(i).getRankIndex()==7)&&(white)))
					{
						returnList.remove(tempMove);
						returnList.add(new Move(square,toSquares.get(i),"queen"));
						returnList.add(new Move(square,toSquares.get(i),"rook"));
						returnList.add(new Move(square,toSquares.get(i),"bishop"));
						returnList.add(new Move(square,toSquares.get(i),"knight"));
					}
				}
		}
		return returnList;
	}
}