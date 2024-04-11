package Models;

import java.util.Scanner;

public class Player {
    private String name;
    private int id;
    private Symbol symbol;
    private PlayerType playerType;

    public Player(String name, int id, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.id = id;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board){
        Scanner scanner = new Scanner(System.in);
        System.out.println("It's " + name + "'s turn");
        int row, col;
        boolean isValidInput = false;

        while(!isValidInput) {
            System.out.println("Please enter row (0-" + (board.getSize() - 1) + "):");
            row = scanner.nextInt();

            System.out.println("Please enter column (0-" + (board.getSize() - 1) + "):");
            col = scanner.nextInt();

            if(row >= 0 && row < board.getSize() && col >= 0 && col < board.getSize()) {
                // Valid input
                Cell cell = board.getBoard().get(row).get(col);
                cell.setCellState(CellState.FILLED);
                cell.setPlayer(this);

                Move move = new Move();
                move.setCell(cell);
                move.setPlayer(this);
                return move;
            } else {
                // Invalid input
                System.out.println("Invalid input. Please enter again.");
            }
        }
        return null; // This should never happen

    }
}
