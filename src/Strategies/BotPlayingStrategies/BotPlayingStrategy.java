package Strategies.BotPlayingStrategies;

import Models.Board;
import Models.Bot;
import Models.Move;

public interface BotPlayingStrategy {
    public
    Move makeMove(Board board, Bot bot);
}
