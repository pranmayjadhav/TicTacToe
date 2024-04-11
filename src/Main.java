import Controllers.GameController;
import Exceptions.BotCountException;
import Exceptions.PlayerCountDimensionMismatchException;
import Exceptions.SymbolCountException;
import Models.*;
import Strategies.winningStrategies.OrderOneWinningStrategy;

import java.util.ArrayList;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws BotCountException, SymbolCountException, PlayerCountDimensionMismatchException {
        GameController gameController = new GameController();

        // TODO take input from user to get player details
        // If user enters 3 players, then create a board of size 4

        Player john = new Player("John", 1, new Symbol('X'), PlayerType.HUMAN);

//        Player jane = new Player("Jane", 2, new Symbol('O'), PlayerType.HUMAN);

        Player bot = new Bot("Bourvita", 3, new Symbol('Y'), PlayerType.BOT, BotDifficultyLevel.EASY);

        Game game = gameController.startGame(3 , Arrays.asList(john, bot), new OrderOneWinningStrategy(3));
        System.out.println("Game is Starting");
//        Game game = new Game();
        while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);
            // do undo
            gameController.undo(game);
        }

        if(gameController.checkState(game).equals(GameState.ENDED)){
            Player winner = gameController.getWinner(game);
            System.out.println("Winner is " + winner.getName());
        } else if (gameController.checkState(game).equals(GameState.DRAW)){
            System.out.println("Game is Drawn");
        }

    }

}