package com.prs.SnakeAndLadder.model;

public class Snake extends BoardEntity {
    protected Snake(Integer start, Integer end) {
        super(start, end);
    }

    @Override
    public void message() {
        System.out.println("Oh no!!! Its a snake");
    }

    @Override
    public String toString() {
        return "S{"+this.getEnd()+"}";
    }
}
