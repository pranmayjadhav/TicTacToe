package factories;

import Models.BotDifficultyLevel;
import Strategies.BotPlayingStrategies.EasyBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static EasyBotPlayingStrategy getStrategy(BotDifficultyLevel botDifficultyLevel) {
        if (botDifficultyLevel == BotDifficultyLevel.EASY) {
            return new EasyBotPlayingStrategy();
        }
        return new EasyBotPlayingStrategy();
    }
}
