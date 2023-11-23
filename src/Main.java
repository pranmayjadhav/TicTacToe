import Controllers.GameController;
import Exceptions.BotCountException;
import Exceptions.PlayerCountDimensionMismatchException;
import Exceptions.SymbolCountException;
import Models.Game;
import Models.GameState;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws BotCountException, SymbolCountException, PlayerCountDimensionMismatchException {
        // Press Alt+Enter with your caret at the highlighted text to see how
        GameController gameController = new GameController();
        Game game = gameController.startGame(3 , new ArrayList<>(), new ArrayList<>());
        System.out.println("Game is Starting");
//        Game game = new Game();
        while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);
            // do undo
        }

        if(gameController.checkState(game).equals(GameState.SUCCESS)){
            System.out.println("Winner is some player");
        } else if (gameController.checkState(game).equals(GameState.DRAW)){
            System.out.println("Game is Drawn");
        }

    }
}