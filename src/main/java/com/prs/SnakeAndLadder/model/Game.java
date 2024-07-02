package com.prs.SnakeAndLadder.model;

import com.prs.SnakeAndLadder.service.DiceService;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {

    private final DiceService diceService;
    private final int dimension;
    private final int noOfDice;
    private final Board board;
    private final Queue<Player> players;
    private final Queue<Player> winners;

    public Game(int dimension, int noOfDice) {
        this.diceService = new DiceService();
        this.dimension = dimension;
        this.noOfDice = noOfDice;
        this.board = new Board(dimension);
        this.players = new LinkedList<>();
        winners = new LinkedList<>();
    }

    public void launchGame() {
        while (players.size() > 1) {
            Player player = players.poll();
            System.out.println(player.getPlayerId()+"'s turn");
            System.out.println("Press r to roll the dice");
            Scanner scanner = new Scanner(System.in);
            char c = scanner.next().charAt(0);
            if (c == 'R' || c == 'r') {
                int move = diceService.rollDice(this.noOfDice);
                System.out.println("Dice: " + move);
                board.makeMove(player, move);
                checkWinner(player);
                board.print();
                printPlayersPosition();
            }

        }
    }

    public void printPlayersPosition() {
        players.forEach(System.out::println);
    }

    public void addPlayers(Player player) {
        this.players.add(player);
    }

    private void checkWinner(Player player) {
        if (player.getPosition() == dimension*dimension) {
            System.out.println("Player "+ player.getPlayerId()+" won the game");
            winners.add(player);
        }
        else {
            players.add(player);
        }
    }

}
