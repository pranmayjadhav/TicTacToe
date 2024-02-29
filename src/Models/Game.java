package Models;

import Exceptions.BotCountException;
import Exceptions.PlayerCountDimensionMismatchException;
import Exceptions.SymbolCountException;
import Strategies.winningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;

    private GameState gameState;
    private int currentPlayerIndex;
    private Player winner;
    private WinningStrategy winningStrategy;

    public Board getBoard(){
        return board;
    }

    public Game(int dimensions, List<Player> players, WinningStrategy winningStrategy) {
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.currentPlayerIndex = 0;
        this.winner = winner;
        this.winningStrategy = winningStrategy;
        this.board = new Board(dimensions);
    }

    public void displayBoard() {
        this.board.displayBoard();
    }

    public void makeMove() {
        // Figure out who's turn is it
        Player currentPlayer = players.get(currentPlayerIndex);

        // Ask that player to tell which cell to move on
        Move move = currentPlayer.makeMove(board);
        moves.add(move);

        if(winningStrategy.checkWinner(move, board)){
            setGameState(GameState.ENDED);
            setWinner(currentPlayer);
            return;
        }
        if(moves.size() == board.getSize() * board.getSize()){
            // Game has drawn
            setGameState(GameState.DRAW);
            return;
        }

        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
    public static Builder getBuilder() {

        Builder builder = new Builder();
        return builder;
    }

    public static class Builder {
        private int dimension ;
        private List<Player> players;
        private WinningStrategy winningStrategy;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;

        }

        public Builder addPlayer(Player player){
            this.players.add(player);
            return this;
        }

//        public Builder addWinningStrategy(WinningStrategy winningStrategy){
//            this.winningStrategy.add(winningStrategy);
//            return this;
//
//        }

        //Validate Bot single bot player
        private void validateBotCount() throws BotCountException {
            int botCount = 0;
            for(Player p : players){
                if(p.getPlayerType().equals(PlayerType.BOT)){
                    botCount += 1;
                }
            }
            if(botCount > 1){
                throw new BotCountException();
            }
        }

        //Validate number of players == dimension -1
        private void validatePlayersCount() throws PlayerCountDimensionMismatchException {


            if(players.size() != dimension - 1){
                throw new PlayerCountDimensionMismatchException();
            }
        }

        private void validateSymbolsCount() throws SymbolCountException {
            Map<Character , Integer> symCount = new HashMap<>();

            for(Player p : players) {
                if (!symCount.containsKey(p.getSymbol().getaChar())) {
                    symCount.put(p.getSymbol().getaChar(), 0);
                }

                symCount.put(p.getSymbol().getaChar(),
                        symCount.get(p.getSymbol().getaChar()) + 1);

                if (symCount.get(p.getSymbol().getaChar()) > 1) {
                    throw new SymbolCountException();
                }
            }
        }
        private void validate() throws BotCountException, PlayerCountDimensionMismatchException, SymbolCountException {
            // validate single Bot players
            validateBotCount();
            // validate no of players == dimension - 1
            validatePlayersCount();
            // validate diff symbol for every player
            validateSymbolsCount();
        }
        public Game build() throws BotCountException, SymbolCountException, PlayerCountDimensionMismatchException {
            validate();
            return new Game(
                    this.dimension,
                    this.players,
                    this.winningStrategy
            );
        }
    }
    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public WinningStrategy getWinningStrategies() {
        return winningStrategy;
    }

    public void setWinningStrategies(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }
}
