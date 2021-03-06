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

package com.kenny.classiq.definitions;

/**
 * Includes the standard definitions of the piece values needed.
 * This reduces the navigation between class files to edit piece
 * values if I ever need to do that.
 * I previously used to work with C++. Since Java lacks the <code>#define</code>
 * tags used to define constants in C++, I found this workaround. Making
 * the members static makes them accessible without using an object, and making
 * them final makes them constant, just the functionality offered by the 
 * <code>#define</code> tags. I have to include the class name, yes, but its
 * better than not having such a functionality at all!
 * @author Kenshin Himura  
 *
 */
public class PieceValues
{
	/**
	 * Holds the value of the king in centipawns.
	 * Much higher than all pieces put together in the game,
	 * to avoid the engine caring about exchanges.
	 */
	public static final int kingValue=39900;
	/**
	 * Holds the value of the queen in centipawns
	 */
	public static final int queenValue=900;
	/**
	 * Holds the value of the rook in centipawns
	 */
	public static final int rookValue=500;
	/**
	 * Holds the value of the bishop in centipawns
	 */
	public static final int bishopValue=300;
	/**
	 * Holds the value of the knight in centipawns
	 */
	public static final int knightValue=300;
	/**
	 * Holds the value of the pawn in centipawns, 
	 * obviously 100, but can be modified to reflect changes in
	 * engine thinking.
	 */
	public static final int pawnValue=100;
}