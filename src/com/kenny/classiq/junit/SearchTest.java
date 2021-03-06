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

package com.kenny.classiq.junit;

import org.junit.Test;

import com.kenny.classiq.Main;
import com.kenny.classiq.definitions.Definitions;
import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

public class SearchTest
{
	@Test
	public void test()
	{
		Main.protocolType="uci";
		Game chess=new Game(Definitions.startPositionFEN);
		Move newMove=new Move(chess.getGameBoard());
		newMove.setMoveString("e2e4");
		chess.showBoard();
		chess.getCurrentPlayer().makeMove(newMove);
		chess.showBoard();
		chess.getPlayerTwo().getMove();
		chess.showBoard();
	}
}
