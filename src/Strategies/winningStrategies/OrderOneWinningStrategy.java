package Strategies.winningStrategies;

import Models.Symbol;

import java.util.List;
import java.util.Map;

public class OrderOneWinningStrategy implements WinningStrategy{
    private List<Map<Symbol, Integer>> rows;
    private List<Map<Symbol, Integer>> cols;
    private Map<Symbol, Integer> diagonal;

}
