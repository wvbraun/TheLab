package tests.games.hex;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.games.hex.board.SimpleGameBoardTest;
import tests.games.hex.board.TileTest;
import tests.games.hex.gameMechanics.LoseByConnectingRulesTest;
import tests.games.hex.gameMechanics.MoveTest;
import tests.games.hex.gameMechanics.StandardRulesTest;


@RunWith(Suite.class)
@SuiteClasses({ SimpleGameBoardTest.class, 
				MoveTest.class, 
				StandardRulesTest.class,
				LoseByConnectingRulesTest.class,
				TileTest.class,
				SimpleGameBoardTest.class
				})
public class AllTests {

}
