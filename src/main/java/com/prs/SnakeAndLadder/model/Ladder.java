package com.prs.SnakeAndLadder.model;

public class Ladder extends BoardEntity {
    protected Ladder(Integer start, Integer end) {
        super(start, end);
    }

    @Override
    public void message() {
        System.out.println("Yaay!!! You got a ladder");
    }

    @Override
    public String toString() {
        return "L{"+getEnd()+"}";
    }
}
