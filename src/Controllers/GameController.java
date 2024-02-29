package Controllers;

import Exceptions.BotCountException;
import Exceptions.PlayerCountDimensionMismatchException;
import Exceptions.SymbolCountException;
import Models.Game;
import Models.GameState;
import Models.Player;
import Strategies.winningStrategies.WinningStrategy;

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
                .setWinningStrategy(winningStrategy)
                .build();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public void displayBoard(Game game){
        game.displayBoard();
    }

    public void getWinner(Game game){

    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public void undo(Game game){

    }

}
