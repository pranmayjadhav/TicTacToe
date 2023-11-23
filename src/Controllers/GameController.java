package Controllers;

import Exceptions.BotCountException;
import Exceptions.PlayerCountDimensionMismatchException;
import Exceptions.SymbolCountException;
import Models.Game;
import Models.GameState;
import Models.Player;
import Strategies.WinningStrategy;

import java.util.Collections;
import java.util.List;

public class GameController {
    public Game startGame(int dimension,
                          List<Player> players,
                          List<WinningStrategy> winningStrategies) throws BotCountException, SymbolCountException, PlayerCountDimensionMismatchException {
        // we will create the game
        // we need to validate
//        game.getbuilder().setplayers(...).setWinning(...);
//        game.addplayer().addplayer().addwinningstrategt();
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game){

    }

    public void displayBoard(Game game){

    }

    public void getWinner(Game game){

    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public void undo(Game game){

    }

}
