package com.prs.SnakeAndLadder.service;

public class DiceService {
    public int rollDice(int d) {
        int min = d;
        int max = 6*d;

        return (int) Math.floor(Math.random()*(max-min+1)+min);
    }
}
