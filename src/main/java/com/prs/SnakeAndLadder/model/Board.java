package com.prs.SnakeAndLadder.model;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final int boardSize;
    private final Map<Integer, BoardEntity> map;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.map = new HashMap<>();
        setUpBoard();
    }

    private void setUpBoard() {
        int cellSize = this.boardSize*this.boardSize;
        for (int i = 0; i < boardSize; i++) {
            int min = 2;

            int max = cellSize-1;
            int start = (int) Math.floor(Math.random()*(max-min+1)+min);
            max = start - 1;
            int end = (int) Math.floor(Math.random()*(max-min+1)+min);

            if (!hasSnakeOrLadder(start)) {
                setBoardEntity(start, new Snake(start, end));
            }

            max = cellSize-1;
            end = (int) Math.floor(Math.random()*(max-min+1)+min);
            max = end-1;
            start = (int) Math.floor(Math.random()*(max-min+1)+min);

            if (!hasSnakeOrLadder(start)) {
                setBoardEntity(start, new Ladder(start, end));
            }
        }
        print();
    }

    private void setBoardEntity(int start, BoardEntity entity) {
        map.put(start, entity);
    }

    public void print() {
        for (int i = this.boardSize*this.boardSize-1; i > 0 ; i--) {
            if (i % this.boardSize == 0) {
                System.out.println();
            }
            System.out.print(i);
            if (hasSnakeOrLadder(i)) {
                BoardEntity boardEntity = map.get(i);
                System.out.print("-"+boardEntity);
            }
            System.out.print("  ");
        }
    }

    public void makeMove(Player player, int move) {
        int newPosition = player.getPosition() + move;
        if (newPosition <= boardSize*boardSize) {
            if (hasSnakeOrLadder(newPosition)) {
                BoardEntity boardEntity = map.get(newPosition);
                boardEntity.message();
                newPosition = boardEntity.getEnd();
            }
            System.out.println(player.getPlayerId() + " moved to " + newPosition);
        }
        else {
            System.out.println("Try again next time !!!");
            newPosition = player.getPosition();
        }
        player.setPosition(newPosition);
    }

    public boolean hasSnakeOrLadder(int i) {
        BoardEntity boardEntity = map.get(i);
        if (boardEntity == null) {
            return false;
        }
        if (boardEntity instanceof Snake || boardEntity instanceof Ladder) {
            return true;
        }
        return false;
    }
}
